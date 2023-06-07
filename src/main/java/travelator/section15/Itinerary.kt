package travelator.section15

import java.time.Duration

data class Itinerary(
	val id: Id<Itinerary>,
	val route: Route
) : Route by route {
	fun hasJourneyLongerThan(duration: Duration) =
		any { it.duration > duration }

	fun withTransformedRoute(transform: (Route).() -> Route) =
		copy(route = transform(route))
}