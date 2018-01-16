package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SuggestedUsersResources;

public class SuggestedUsersResourcesWrapper extends WrapperBase implements SuggestedUsersResources {

    public SuggestedUsersResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersSuggestionsSlug, (resources) -> {
            try {
                return Either.right(resources.getUserSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersSuggestions, (resources) -> {
            try {
                return Either.right(resources.getSuggestedUserCategories());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getMemberSuggestions(String categorySlug) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersSuggestionsSlugMembers, (resources) -> {
            try {
                return Either.right(resources.getMemberSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
