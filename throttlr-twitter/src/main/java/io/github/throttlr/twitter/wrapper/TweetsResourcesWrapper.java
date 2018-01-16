package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.TweetsResources;

import java.io.File;
import java.io.InputStream;

public class TweetsResourcesWrapper extends WrapperBase<TweetsResources> implements TweetsResources {

    public TweetsResourcesWrapper(TweetsResources tweetsResources, ThrottleStrategy throttleStrategy) {
        super(tweetsResources, throttleStrategy);
    }

    @Override
    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesRetweetersIds, () -> {
            try {
                return Either.right(resources.getRetweets(statusId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesRetweetersIds, () -> {
            try {
                return Either.right(resources.getRetweeterIds(statusId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesRetweetersIds, () -> {
            try {
                return Either.right(resources.getRetweeterIds(statusId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status showStatus(long id) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesShowId, () -> {
            try {
                return Either.right(resources.showStatus(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status destroyStatus(long statusId) throws TwitterException {
        return resources.destroyStatus(statusId);
    }

    @Override
    public Status updateStatus(String status) throws TwitterException {
        return resources.updateStatus(status);
    }

    @Override
    public Status updateStatus(StatusUpdate latestStatus) throws TwitterException {
        return resources.updateStatus(latestStatus);
    }

    @Override
    public Status retweetStatus(long statusId) throws TwitterException {
        return resources.retweetStatus(statusId);
    }

    @Override
    public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
        return resources.getOEmbed(req);
    }

    @Override
    public ResponseList<Status> lookup(long... ids) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.statusesLookup, () -> {
            try {
                return Either.right(resources.lookup(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UploadedMedia uploadMedia(File mediaFile) throws TwitterException {
        return resources.uploadMedia(mediaFile);
    }

    @Override
    public UploadedMedia uploadMedia(String fileName, InputStream media) throws TwitterException {
        return resources.uploadMedia(fileName, media);
    }
}
