package travelator.section14

typealias Route = List<Journey>

fun Route.costs() = map { it.price }