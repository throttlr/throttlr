package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.TimelinesResources;

public class TimelinesResourcesWrapper extends WrapperBase implements TimelinesResources {

    public TimelinesResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline(screenName, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline(userId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesUserTimeline, (resources) -> {
            try {
                return Either.right(resources.getUserTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
