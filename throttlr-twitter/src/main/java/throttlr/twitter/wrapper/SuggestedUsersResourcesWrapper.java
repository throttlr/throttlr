package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SuggestedUsersResources;

public class SuggestedUsersResourcesWrapper implements SuggestedUsersResources {

    private ThrottleStrategy throttleStrategy;
    private SuggestedUsersResources suggestedUsersResources;

    public SuggestedUsersResourcesWrapper(SuggestedUsersResources suggestedUsersResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.suggestedUsersResources = suggestedUsersResources;
    }

    @Override
    public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
        return throttleStrategy.throttle("/users/suggestions/:slug", () -> {
            try {
                return Either.right(suggestedUsersResources.getUserSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return throttleStrategy.throttle("/users/suggestions", () -> {
            try {
                return Either.right(suggestedUsersResources.getSuggestedUserCategories());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getMemberSuggestions(String categorySlug) throws TwitterException {
        return throttleStrategy.throttle("/users/suggestions/:slug/members", () -> {
            try {
                return Either.right(suggestedUsersResources.getMemberSuggestions(categorySlug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
