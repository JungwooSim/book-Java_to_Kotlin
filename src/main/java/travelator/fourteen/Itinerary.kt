package travelator.fourteen

import travelator.fourteen.money.Money

data class Itinerary(
	val id: Id<Itinerary>,
	val route: Route,
	val accommodations: List<Accommodation> = emptyList()
) {

	fun costs(): List<Money> = route.costs() + accommodations.costs()
}

fun Iterable<Accommodation>.costs(): List<Money> = flatMap { it.costs() }