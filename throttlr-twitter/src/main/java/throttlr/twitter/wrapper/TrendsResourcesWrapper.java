package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.TrendsResources;

public class TrendsResourcesWrapper implements TrendsResources {

    private ThrottleStrategy throttleStrategy;
    private TrendsResources trendsResources;

    public TrendsResourcesWrapper(TrendsResources trendsResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.trendsResources = trendsResources;
    }

    @Override
    public Trends getPlaceTrends(int woeid) throws TwitterException {
        return throttleStrategy.throttle("/trends/place", () -> {
            try {
                return Either.right(trendsResources.getPlaceTrends(woeid));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return throttleStrategy.throttle("/trends/available", () -> {
            try {
                return Either.right(trendsResources.getAvailableTrends());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getClosestTrends(GeoLocation location) throws TwitterException {
        return throttleStrategy.throttle("/trends/closest", () -> {
            try {
                return Either.right(trendsResources.getClosestTrends(location));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
