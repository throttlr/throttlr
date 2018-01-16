package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.TwitterException;
import twitter4j.api.SavedSearchesResources;

public class SavedSearchesResourcesWrapper extends WrapperBase<SavedSearchesResources> implements SavedSearchesResources {

    public SavedSearchesResourcesWrapper(SavedSearchesResources savedSearchesResources, ThrottleStrategy throttleStrategy) {
        super(savedSearchesResources, throttleStrategy);
    }

    @Override
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.savedSearchesList, () -> {
            try {
                return Either.right(resources.getSavedSearches());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch showSavedSearch(long id) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.savedSearchesShowId, () -> {
            try {
                return Either.right(resources.showSavedSearch(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch createSavedSearch(String query) throws TwitterException {
        return resources.createSavedSearch(query);
    }

    @Override
    public SavedSearch destroySavedSearch(long id) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.savedSearchesDestroyId, () -> {
            try {
                return Either.right(resources.destroySavedSearch(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
