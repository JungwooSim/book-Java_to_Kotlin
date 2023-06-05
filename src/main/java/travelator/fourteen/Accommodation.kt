package travelator.fourteen

import travelator.fourteen.money.Money

data class Accommodation(
	val totalPrice: Money
	// and other fields...
)

fun Accommodation.costs() =
	listOf(totalPrice)