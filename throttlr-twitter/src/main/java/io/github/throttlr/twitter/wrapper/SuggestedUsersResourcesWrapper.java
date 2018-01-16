package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SuggestedUsersResources;

public class SuggestedUsersResourcesWrapper extends WrapperBase<SuggestedUsersResources> implements SuggestedUsersResources {

    public SuggestedUsersResourcesWrapper(SuggestedUsersResources suggestedUsersResources, ThrottleStrategy throttleStrategy) {
        super(suggestedUsersResources, throttleStrategy);
    }

    @Override
    public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersSuggestionsSlug, () -> {
            try {
                return Either.right(resources.getUserSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersSuggestions, () -> {
            try {
                return Either.right(resources.getSuggestedUserCategories());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getMemberSuggestions(String categorySlug) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersSuggestionsSlugMembers, () -> {
            try {
                return Either.right(resources.getMemberSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
