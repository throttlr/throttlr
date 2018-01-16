package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.TweetsResources;

import java.io.File;
import java.io.InputStream;

public class TweetsResourcesWrapper extends WrapperBase implements TweetsResources {

    public TweetsResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesRetweetsId, (resources) -> {
            try {
                return Either.right(resources.getRetweets(statusId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesRetweetersIds, (resources) -> {
            try {
                return Either.right(resources.getRetweeterIds(statusId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesRetweetersIds, (resources) -> {
            try {
                return Either.right(resources.getRetweeterIds(statusId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status showStatus(long id) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesShowId, (resources) -> {
            try {
                return Either.right(resources.showStatus(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status destroyStatus(long statusId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Status updateStatus(String status) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Status updateStatus(StatusUpdate latestStatus) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Status retweetStatus(long statusId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> lookup(long... ids) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.statusesLookup, (resources) -> {
            try {
                return Either.right(resources.lookup(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UploadedMedia uploadMedia(File mediaFile) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UploadedMedia uploadMedia(String fileName, InputStream media) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
