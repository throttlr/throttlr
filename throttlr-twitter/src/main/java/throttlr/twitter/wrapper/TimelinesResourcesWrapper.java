package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.TimelinesResources;

public class TimelinesResourcesWrapper implements TimelinesResources {

    private ThrottleStrategy throttleStrategy;
    private TimelinesResources timelinesResources;

    public TimelinesResourcesWrapper(TimelinesResources timelinesResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.timelinesResources = timelinesResources;
    }

    @Override
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        return throttleStrategy.throttle("/statuses/mentions_timeline", () -> {
            try {
                return Either.right(timelinesResources.getMentionsTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/mentions_timeline", () -> {
            try {
                return Either.right(timelinesResources.getMentionsTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName, Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline(screenName, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId, Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline(userId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName) throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/user_timeline", () -> {
            try {
                return Either.right(timelinesResources.getUserTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        return throttleStrategy.throttle("/statuses/home_timeline", () -> {
            try {
                return Either.right(timelinesResources.getHomeTimeline());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/home_timeline", () -> {
            try {
                return Either.right(timelinesResources.getHomeTimeline(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return throttleStrategy.throttle("/statuses/retweets_of_me", () -> {
            try {
                return Either.right(timelinesResources.getRetweetsOfMe());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/statuses/retweets_of_me", () -> {
            try {
                return Either.right(timelinesResources.getRetweetsOfMe(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
