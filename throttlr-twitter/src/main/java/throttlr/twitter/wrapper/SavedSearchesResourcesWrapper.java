package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.TwitterException;
import twitter4j.api.SavedSearchesResources;

public class SavedSearchesResourcesWrapper implements SavedSearchesResources {

    private ThrottleStrategy throttleStrategy;
    private SavedSearchesResources savedSearchesResources;

    public SavedSearchesResourcesWrapper(SavedSearchesResources savedSearchesResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.savedSearchesResources = savedSearchesResources;
    }

    @Override
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return throttleStrategy.throttle("/saved_searches/list", () -> {
            try {
                return Either.right(savedSearchesResources.getSavedSearches());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch showSavedSearch(long id) throws TwitterException {
        return throttleStrategy.throttle("/saved_searches/show/:id", () -> {
            try {
                return Either.right(savedSearchesResources.showSavedSearch(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch createSavedSearch(String query) throws TwitterException {
        return savedSearchesResources.createSavedSearch(query);
    }

    @Override
    public SavedSearch destroySavedSearch(long id) throws TwitterException {
        return throttleStrategy.throttle("/saved_searches/destroy/:id", () -> {
            try {
                return Either.right(savedSearchesResources.destroySavedSearch(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
