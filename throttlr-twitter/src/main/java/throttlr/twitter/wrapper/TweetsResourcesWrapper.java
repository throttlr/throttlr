package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.TweetsResources;

import java.io.File;
import java.io.InputStream;

public class TweetsResourcesWrapper implements TweetsResources {

    private ThrottleStrategy throttleStrategy;
    private TweetsResources tweetsResources;

    public TweetsResourcesWrapper(TweetsResources tweetsResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.tweetsResources = tweetsResources;
    }

    @Override
    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
        return throttleStrategy.throttle("/statuses/retweets/:id", () -> {
            try {
                return Either.right(tweetsResources.getRetweets(statusId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/statuses/retweeters/ids", () -> {
            try {
                return Either.right(tweetsResources.getRetweeterIds(statusId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/statuses/retweeters/ids", () -> {
            try {
                return Either.right(tweetsResources.getRetweeterIds(statusId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status showStatus(long id) throws TwitterException {
        return throttleStrategy.throttle("/statuses/show/:id", () -> {
            try {
                return Either.right(tweetsResources.showStatus(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status destroyStatus(long statusId) throws TwitterException {
        return tweetsResources.destroyStatus(statusId);
    }

    @Override
    public Status updateStatus(String status) throws TwitterException {
        return tweetsResources.updateStatus(status);
    }

    @Override
    public Status updateStatus(StatusUpdate latestStatus) throws TwitterException {
        return tweetsResources.updateStatus(latestStatus);
    }

    @Override
    public Status retweetStatus(long statusId) throws TwitterException {
        return tweetsResources.retweetStatus(statusId);
    }

    @Override
    public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
        return tweetsResources.getOEmbed(req);
    }

    @Override
    public ResponseList<Status> lookup(long... ids) throws TwitterException {
        return throttleStrategy.throttle("/statuses/lookup", () -> {
            try {
                return Either.right(tweetsResources.lookup(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UploadedMedia uploadMedia(File mediaFile) throws TwitterException {
        return tweetsResources.uploadMedia(mediaFile);
    }

    @Override
    public UploadedMedia uploadMedia(String fileName, InputStream media) throws TwitterException {
        return tweetsResources.uploadMedia(fileName, media);
    }
}
