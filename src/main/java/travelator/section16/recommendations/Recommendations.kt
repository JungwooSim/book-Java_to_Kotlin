package travelator.section16.recommendations

import travelator.section16.destinations.FeaturedDestination
import travelator.section16.domain.Location

class Recommendations(
	private val destinationFinder: (Location) -> List<FeaturedDestination>,
	private val distanceInMetersBetween: (Location, Location) -> Int,
) {

	fun recommendationsFor(
		journey: Set<Location>
	): List<FeaturedDestinationSuggestion> =
		journey.flatMap { location -> recommendationsFor(location) }
			.deduplicated()
			.sortedBy { it.distanceMeters }

	fun recommendationsFor(
		location: Location,
	): List<FeaturedDestinationSuggestion> =
		destinationFinder(location)
			.map { featuredDestination ->
				FeaturedDestinationSuggestion(
					location,
					featuredDestination,
					distanceInMetersBetween(
						location,
						featuredDestination.location
					)
				)
			}
}

private fun List<FeaturedDestinationSuggestion>.deduplicated() =
	groupBy { it.suggestion }
		.values
		.map { it.closestToJourneyLocation() }

private fun List<FeaturedDestinationSuggestion>.closestToJourneyLocation() =
	minByOrNull { it.distanceMeters } ?: error("Unexpected empty group")