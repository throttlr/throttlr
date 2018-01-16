package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.TwitterException;
import twitter4j.api.SavedSearchesResources;

public class SavedSearchesResourcesWrapper extends WrapperBase implements SavedSearchesResources {

    public SavedSearchesResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.savedSearchesList, (resources) -> {
            try {
                return Either.right(resources.getSavedSearches());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch showSavedSearch(long id) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.savedSearchesShowId, (resources) -> {
            try {
                return Either.right(resources.showSavedSearch(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public SavedSearch createSavedSearch(String query) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public SavedSearch destroySavedSearch(long id) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
