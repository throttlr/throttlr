package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.FavoritesResources;

public class FavoritesResourcesWrapper extends WrapperBase<FavoritesResources> implements FavoritesResources {

    public FavoritesResourcesWrapper(FavoritesResources favoritesResources, ThrottleStrategy throttleStrategy) {
        super(favoritesResources, throttleStrategy);
    }

    @Override
    public ResponseList<Status> getFavorites() throws TwitterException {
        return resources.getFavorites();
    }

    @Override
    public ResponseList<Status> getFavorites(long userId) throws TwitterException {
        return resources.getFavorites(userId);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName) throws TwitterException {
        return resources.getFavorites(screenName);
    }

    @Override
    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        return resources.getFavorites(paging);
    }

    @Override
    public ResponseList<Status> getFavorites(long userId, Paging paging) throws TwitterException {
        return resources.getFavorites(userId, paging);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName, Paging paging) throws TwitterException {
        return resources.getFavorites(screenName, paging);
    }

    @Override
    public Status createFavorite(long id) throws TwitterException {
        return resources.createFavorite(id);
    }

    @Override
    public Status destroyFavorite(long id) throws TwitterException {
        return resources.destroyFavorite(id);
    }
}
