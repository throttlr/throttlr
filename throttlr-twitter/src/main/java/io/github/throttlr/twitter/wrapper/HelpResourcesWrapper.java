package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.api.HelpResources;

import java.util.Map;

public class HelpResourcesWrapper extends WrapperBase<HelpResources> implements HelpResources {

    public HelpResourcesWrapper(HelpResources helpResources, ThrottleStrategy throttleStrategy) {
        super(helpResources, throttleStrategy);
    }

    @Override
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.helpConfiguration, () -> {
            try {
                return Either.right(resources.getAPIConfiguration());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Language> getLanguages() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.helpLanguages, () -> {
            try {
                return Either.right(resources.getLanguages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public String getPrivacyPolicy() throws TwitterException {
        return resources.getPrivacyPolicy();
    }

    @Override
    public String getTermsOfService() throws TwitterException {
        return resources.getTermsOfService();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        return resources.getRateLimitStatus();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus(String... resources) throws TwitterException {
        return this.resources.getRateLimitStatus(resources);
    }
}
