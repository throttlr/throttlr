package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.TimelinesResources;

public class TimelinesResourcesWrapper extends WrapperBase<TimelinesResources> implements TimelinesResources {

    public TimelinesResourcesWrapper(TimelinesResources timelinesResources, ThrottleStrategy throttleStrategy) {
        super(timelinesResources, throttleStrategy);
    }

    @Override
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesMentionsTimeline, () -> {
            try {
                return Either.right(resources.getMentionsTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesMentionsTimeline, () -> {
            try {
                return Either.right(resources.getMentionsTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName, Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline(screenName, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId, Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline(userId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesUserTimeline, () -> {
            try {
                return Either.right(resources.getUserTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesHomeTimeline, () -> {
            try {
                return Either.right(resources.getHomeTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesHomeTimeline, () -> {
            try {
                return Either.right(resources.getHomeTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesRetweetsOfMe, () -> {
            try {
                return Either.right(resources.getRetweetsOfMe());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesRetweetsOfMe, () -> {
            try {
                return Either.right(resources.getRetweetsOfMe(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
