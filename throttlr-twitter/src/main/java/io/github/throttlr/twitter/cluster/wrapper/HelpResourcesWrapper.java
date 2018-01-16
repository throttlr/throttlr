package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.api.HelpResources;

import java.util.Map;

public class HelpResourcesWrapper extends WrapperBase implements HelpResources {

    public HelpResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.helpConfiguration, (resources) -> {
            try {
                return Either.right(resources.getAPIConfiguration());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Language> getLanguages() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.helpLanguages, (resources) -> {
            try {
                return Either.right(resources.getLanguages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public String getPrivacyPolicy() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTermsOfService() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus(String... resources) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
