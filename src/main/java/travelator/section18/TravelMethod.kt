package travelator.section18

enum class TravelMethod {
	SEA,
	RAIL,
	BUS,
	CAR,
	CAMEL;

	val userReadableName: String get() = name.toLowerCase()
}