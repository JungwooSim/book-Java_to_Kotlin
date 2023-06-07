package travelator.section16.destinations;

import travelator.section16.domain.Location;

import java.util.List;
public interface FeaturedDestinations {
    List<FeaturedDestination> findCloseTo(Location location);
    FeaturedDestination findClosest(Location location);

    FeaturedDestination add(FeaturedDestinationData destination);
    void remove(FeaturedDestination destination);
    void update(FeaturedDestination destination);
}
