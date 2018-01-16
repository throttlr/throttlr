package io.github.throttlr.twitter.cluster.strategy;

import io.github.throttlr.twitter.internal.Either;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterResponse;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public interface LoadBalanceStrategy {
    void init(Map<Long, Twitter> targets);

    void add(Long id, Twitter target);

    Set<Long> getTwitterIdSet();

    <T extends TwitterResponse> T balance(String resourceFamily, Function<Twitter, Either<TwitterException, T>> function) throws TwitterException;
}
