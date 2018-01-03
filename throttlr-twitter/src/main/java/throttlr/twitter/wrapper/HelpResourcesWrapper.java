package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.api.HelpResources;

import java.util.Map;

public class HelpResourcesWrapper implements HelpResources {

    private ThrottleStrategy throttleStrategy;
    private HelpResources helpResources;

    public HelpResourcesWrapper(HelpResources helpResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.helpResources = helpResources;
    }

    @Override
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return throttleStrategy.throttle("/help/configuration", () -> {
            try {
                return Either.right(helpResources.getAPIConfiguration());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Language> getLanguages() throws TwitterException {
        return throttleStrategy.throttle("/help/languages", () -> {
            try {
                return Either.right(helpResources.getLanguages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public String getPrivacyPolicy() throws TwitterException {
        return helpResources.getPrivacyPolicy();
    }

    @Override
    public String getTermsOfService() throws TwitterException {
        return helpResources.getTermsOfService();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        return helpResources.getRateLimitStatus();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus(String... resources) throws TwitterException {
        return helpResources.getRateLimitStatus(resources);
    }
}
