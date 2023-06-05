package travelator.fourteen

import travelator.fourteen.money.CurrencyConversion
import travelator.fourteen.money.Money

data class CostSummary(
    val lines: List<CurrencyConversion>,
    val total: Money
)