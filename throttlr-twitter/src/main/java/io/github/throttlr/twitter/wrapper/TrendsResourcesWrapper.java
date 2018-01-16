package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.TrendsResources;

public class TrendsResourcesWrapper extends WrapperBase<TrendsResources> implements TrendsResources {

    public TrendsResourcesWrapper(TrendsResources trendsResources, ThrottleStrategy throttleStrategy) {
        super(trendsResources, throttleStrategy);
    }

    @Override
    public Trends getPlaceTrends(int woeid) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.trendsPlace, () -> {
            try {
                return Either.right(resources.getPlaceTrends(woeid));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.trendsAvailable, () -> {
            try {
                return Either.right(resources.getAvailableTrends());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getClosestTrends(GeoLocation location) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.trendsClosest, () -> {
            try {
                return Either.right(resources.getClosestTrends(location));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
