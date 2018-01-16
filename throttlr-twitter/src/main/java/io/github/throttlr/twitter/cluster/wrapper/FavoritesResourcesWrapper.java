package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.FavoritesResources;

public class FavoritesResourcesWrapper extends WrapperBase implements FavoritesResources {

    public FavoritesResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<Status> getFavorites() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getFavorites(long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.uncategorized, (resources) -> {
            try {
                return Either.right(resources.getFavorites(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.uncategorized, (resources) -> {
            try {
                return Either.right(resources.getFavorites(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<Status> getFavorites(long userId, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.uncategorized, (resources) -> {
            try {
                return Either.right(resources.getFavorites(userId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.uncategorized, (resources) -> {
            try {
                return Either.right(resources.getFavorites(screenName, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Status createFavorite(long id) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Status destroyFavorite(long id) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
