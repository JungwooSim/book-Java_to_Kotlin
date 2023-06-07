package travelator.section16.recommendations

import travelator.section16.destinations.FeaturedDestination
import travelator.section16.domain.Location

data class FeaturedDestinationSuggestion(
	val routeLocation: Location,
	val suggestion: FeaturedDestination,
	val distanceMeters: Int
)