package io.github.throttlr.twitter.cluster.strategy;

import io.github.throttlr.twitter.internal.Either;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterResponse;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class RoundRobinStrategy implements LoadBalanceStrategy {

    class RoundRobinIterator implements Iterator<Long> {

        private Iterator<Long> iterator = null;
        private Supplier<Collection<Long>> supplier;

        RoundRobinIterator(Supplier<Collection<Long>> supplier) {
            this.supplier = supplier;
        }

        @Override
        public boolean hasNext() {
            synchronized (this) {
                if (iterator == null || !iterator.hasNext()) {
                    iterator = supplier.get().iterator();
                }
                return iterator.hasNext();
            }
        }

        @Override
        public Long next() {
            synchronized (this) {
                if (iterator == null || !iterator.hasNext()) {
                    iterator = supplier.get().iterator();
                }
                return iterator.next();
            }
        }
    }

    private final Map<Long, Twitter> targets = new HashMap<>();
    private final Map<String, RoundRobinIterator> iterators = new HashMap<>();

    @Override
    public void init(Map<Long, Twitter> targets) {
        synchronized (this) {
            this.targets.clear();
            this.iterators.clear();
            this.targets.putAll(targets);
        }
    }

    @Override
    public void add(Long id, Twitter target) {
        synchronized (this) {
            targets.put(id, target);
        }
    }

    @Override
    public Set<Long> getTwitterIdSet() {
        return targets.keySet();
    }

    @Override
    public <T extends TwitterResponse> T balance(String resourceFamily, Function<Twitter, Either<TwitterException, T>> function) throws TwitterException {
        Twitter twitter;
        synchronized (this) {
            RoundRobinIterator iterator = iterators.get(resourceFamily);
            if (iterator == null) {
                iterator = new RoundRobinIterator(targets::keySet);
                iterators.put(resourceFamily, iterator);
            }
            twitter = targets.get(iterator.next());
        }
        Either<TwitterException, T> either = function.apply(twitter);
        if (either.isLeft()) {
            throw either.getLeft();
        } else {
            return either.getRight();
        }
    }
}
