package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SpamReportingResource;

public class SpamReportingResourceWrapper extends WrapperBase implements SpamReportingResource {

    public SpamReportingResourceWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public User reportSpam(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User reportSpam(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
