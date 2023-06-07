package travelator.section14

import travelator.section14.money.CurrencyConversion
import travelator.section14.money.Money

data class CostSummary(
    val lines: List<CurrencyConversion>,
    val total: Money
)