package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SpamReportingResource;

public class SpamReportingResourceWrapper extends WrapperBase<SpamReportingResource> implements SpamReportingResource {

    public SpamReportingResourceWrapper(SpamReportingResource spamReportingResource, ThrottleStrategy throttleStrategy) {
        super(spamReportingResource, throttleStrategy);
    }

    @Override
    public User reportSpam(long userId) throws TwitterException {
        return resources.reportSpam(userId);
    }

    @Override
    public User reportSpam(String screenName) throws TwitterException {
        return resources.reportSpam(screenName);
    }
}
