package io.github.throttlr.twitter;

import io.github.throttlr.twitter.cluster.ThrottlrTwitterBalancerImpl;
import io.github.throttlr.twitter.cluster.strategy.RoundRobinStrategy;
import io.github.throttlr.twitter.internal.SystemTimeSource;
import io.github.throttlr.twitter.strategy.CruiseThrottleStrategy;
import io.github.throttlr.twitter.strategy.MaxThrottleStrategy;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.HashMap;
import java.util.Map;

public class ThrottlrTwitterFactory {
    public static ThrottlrTwitter createCruiserThrottleInstance(Twitter twitter) {
        return new ThrottlrTwitter(twitter, new CruiseThrottleStrategy(new SystemTimeSource()));
    }

    public static ThrottlrTwitter createMaxThrottleInstance(Twitter twitter) {
        return new ThrottlrTwitter(twitter, new MaxThrottleStrategy(new SystemTimeSource()));
    }

    public static ThrottlrTwitterBalancerImpl buildBalancerInstance(Map<Long, Twitter> twitters) throws TwitterException {
        Map<Long, Twitter> throttlrTwitterMap = new HashMap<>();
        for (Long id : twitters.keySet()) {
            throttlrTwitterMap.put(id, new ThrottlrTwitter(twitters.get(id), new MaxThrottleStrategy(new SystemTimeSource())));
        }
        return new ThrottlrTwitterBalancerImpl(throttlrTwitterMap, new RoundRobinStrategy());
    }
}
