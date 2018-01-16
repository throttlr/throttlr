package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.PlacesGeoResources;

public class PlacesGeoResourcesWrapper extends WrapperBase<PlacesGeoResources> implements PlacesGeoResources {

    public PlacesGeoResourcesWrapper(PlacesGeoResources placesGeoResources, ThrottleStrategy throttleStrategy) {
        super(placesGeoResources, throttleStrategy);
    }

    @Override
    public Place getGeoDetails(String placeId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.geoIdPlaceId, () -> {
            try {
                return Either.right(resources.getGeoDetails(placeId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> reverseGeoCode(GeoQuery query) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.geoReverseGeocode, () -> {
            try {
                return Either.right(resources.reverseGeoCode(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> searchPlaces(GeoQuery query) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.geoSearch, () -> {
            try {
                return Either.right(resources.searchPlaces(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> getSimilarPlaces(GeoLocation location, String name, String containedWithin, String streetAddress) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.geoSimilarPlaces, () -> {
            try {
                return Either.right(resources.getSimilarPlaces(location, name, containedWithin, streetAddress));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
