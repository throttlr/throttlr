package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.api.FavoritesResources;

public class FavoritesResourcesWrapper implements FavoritesResources {

    private ThrottleStrategy throttleStrategy;
    private FavoritesResources favoritesResources;

    public FavoritesResourcesWrapper(FavoritesResources favoritesResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.favoritesResources = favoritesResources;
    }

    @Override
    public ResponseList<Status> getFavorites() throws TwitterException {
        return favoritesResources.getFavorites();
    }

    @Override
    public ResponseList<Status> getFavorites(long userId) throws TwitterException {
        return favoritesResources.getFavorites(userId);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName) throws TwitterException {
        return favoritesResources.getFavorites(screenName);
    }

    @Override
    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(paging);
    }

    @Override
    public ResponseList<Status> getFavorites(long userId, Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(userId, paging);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName, Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(screenName, paging);
    }

    @Override
    public Status createFavorite(long id) throws TwitterException {
        return favoritesResources.createFavorite(id);
    }

    @Override
    public Status destroyFavorite(long id) throws TwitterException {
        return favoritesResources.destroyFavorite(id);
    }
}
