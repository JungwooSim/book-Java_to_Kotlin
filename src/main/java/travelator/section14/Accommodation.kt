package travelator.section14

import travelator.section14.money.Money

data class Accommodation(
	val totalPrice: Money
	// and other fields...
)

fun Accommodation.costs() =
	listOf(totalPrice)