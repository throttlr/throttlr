package io.github.throttlr.twitter.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.internal.TimeSource;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterException;
import twitter4j.TwitterResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CruiseThrottleStrategy implements ThrottleStrategy {

    private final TimeSource timeSource;
    private final Map<String, RateLimitStatus> rateLimits = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CruiseThrottleStrategy(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public <T extends TwitterResponse> T throttle(String resourceFamily, Supplier<Either<TwitterException, T>> supplier) throws TwitterException {
        synchronized (rateLimits) {
            try {
                RateLimitStatus rateLimitStatus = rateLimits.get(resourceFamily);
                int now = timeSource.getNowTimeInSeconds();
                if (rateLimitStatus != null && now < rateLimitStatus.getResetTimeInSeconds()) {
                    // Rate limit is now effective
                    int reset = rateLimitStatus.getResetTimeInSeconds();
                    if (0 < rateLimitStatus.getRemaining()) {
                        long timeout = (1000L * (reset - now)) / rateLimitStatus.getRemaining();
                        logger.debug("Cruise wait {} milliseconds with {} remains for {}", timeout, rateLimitStatus.getRemaining(), resourceFamily);
                        rateLimits.wait(timeout);
                    } else {
                        long timeout = 1000L * (reset - now);
                        logger.debug("Cruise wait {} milliseconds by no remains for {}", timeout, resourceFamily);
                        rateLimits.wait(timeout);
                    }
                }
                Either<TwitterException, T> either = supplier.get();
                if (either.isRight()) {
                    rateLimits.put(resourceFamily, either.getRight().getRateLimitStatus());
                    return either.getRight();
                } else {
                    throw either.getLeft();
                }
            } catch (InterruptedException e) {
                throw new TwitterException("Interrupted in wait progress", e);
            }
        }
    }
}
