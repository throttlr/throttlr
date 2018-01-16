package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.TrendsResources;

public class TrendsResourcesWrapper extends WrapperBase implements TrendsResources {

    public TrendsResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public Trends getPlaceTrends(int woeid) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.trendsPlace, (resources) -> {
            try {
                return Either.right(resources.getPlaceTrends(woeid));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.trendsAvailable, (resources) -> {
            try {
                return Either.right(resources.getAvailableTrends());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Location> getClosestTrends(GeoLocation location) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.trendsClosest, (resources) -> {
            try {
                return Either.right(resources.getClosestTrends(location));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
