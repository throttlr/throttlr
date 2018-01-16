package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.PlacesGeoResources;

public class PlacesGeoResourcesWrapper extends WrapperBase implements PlacesGeoResources {

    public PlacesGeoResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public Place getGeoDetails(String placeId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.geoIdPlaceId, (resources) -> {
            try {
                return Either.right(resources.getGeoDetails(placeId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> reverseGeoCode(GeoQuery query) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.geoReverseGeocode, (resources) -> {
            try {
                return Either.right(resources.reverseGeoCode(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> searchPlaces(GeoQuery query) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.geoSearch, (resources) -> {
            try {
                return Either.right(resources.searchPlaces(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> getSimilarPlaces(GeoLocation location, String name, String containedWithin, String streetAddress) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.geoSimilarPlaces, (resources) -> {
            try {
                return Either.right(resources.getSimilarPlaces(location, name, containedWithin, streetAddress));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
