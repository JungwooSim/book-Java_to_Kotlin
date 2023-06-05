package travelator.fourteen

typealias Route = List<Journey>

fun Route.costs() = map { it.price }