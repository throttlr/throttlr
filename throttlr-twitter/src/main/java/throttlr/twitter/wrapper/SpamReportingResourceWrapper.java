package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SpamReportingResource;

public class SpamReportingResourceWrapper implements SpamReportingResource {

    private ThrottleStrategy throttleStrategy;
    private SpamReportingResource spamReportingResource;

    public SpamReportingResourceWrapper(SpamReportingResource spamReportingResource, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.spamReportingResource = spamReportingResource;
    }

    @Override
    public User reportSpam(long userId) throws TwitterException {
        return spamReportingResource.reportSpam(userId);
    }

    @Override
    public User reportSpam(String screenName) throws TwitterException {
        return spamReportingResource.reportSpam(screenName);
    }
}
