package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.PlacesGeoResources;

public class PlacesGeoResourcesWrapper implements PlacesGeoResources {

    private ThrottleStrategy throttleStrategy;
    private PlacesGeoResources placesGeoResources;

    public PlacesGeoResourcesWrapper(PlacesGeoResources placesGeoResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.placesGeoResources = placesGeoResources;
    }

    @Override
    public Place getGeoDetails(String placeId) throws TwitterException {
        return throttleStrategy.throttle("/geo/id/:place_id", () -> {
            try {
                return Either.right(placesGeoResources.getGeoDetails(placeId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> reverseGeoCode(GeoQuery query) throws TwitterException {
        return throttleStrategy.throttle("/geo/reverse_geocode", () -> {
            try {
                return Either.right(placesGeoResources.reverseGeoCode(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> searchPlaces(GeoQuery query) throws TwitterException {
        return throttleStrategy.throttle("/geo/search", () -> {
            try {
                return Either.right(placesGeoResources.searchPlaces(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Place> getSimilarPlaces(GeoLocation location, String name, String containedWithin, String streetAddress) throws TwitterException {
        return throttleStrategy.throttle("/geo/similar_places", () -> {
            try {
                return Either.right(placesGeoResources.getSimilarPlaces(location, name, containedWithin, streetAddress));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
