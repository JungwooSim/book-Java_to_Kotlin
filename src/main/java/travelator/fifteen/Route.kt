package travelator.fifteen

import java.time.Duration

typealias Route = List<Journey>

fun Route(journeys: List<Journey>) = journeys

val Route.journeys get() = this

val Route.duration: Duration
	get() = Duration.between(
		first().departureTime,
		last().arrivalTime
	)

val Route.arrivesAt: Location
	get() = last().arrivesAt

operator fun Route.get(index: Int) = journeys[index]

fun Route.size(): Int = journeys.size

fun Route.withJourneyAt(index: Int, replacedBy: Journey): Route {
	val newJourneys = ArrayList(journeys)
	newJourneys[index] = replacedBy
	return Route(newJourneys)
}

val Route.departsFrom: Location
	get() = first().departsFrom