package travelator.section18

val ItineraryItem.costs: List<Money>
	get() = when (this) {
		is Accommodation -> listOf(totalPrice)
		is Attraction -> emptyList<Money>()
		is Journey -> listOf(price)
		is RestaurantBooking -> emptyList<Money>()
	}