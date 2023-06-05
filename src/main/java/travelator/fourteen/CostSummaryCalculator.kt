package travelator.fourteen

import travelator.fourteen.money.ExchangeRates
import travelator.fourteen.money.Money
import java.util.Currency

class CostSummaryCalculator(
    private val userCurrency: Currency,
    private val exchangeRates: ExchangeRates
) {
    private val currencyTotals = mutableMapOf<Currency, Money>()

    fun summarise(costs: Iterable<Money>): CostSummary {
        val currencyTotals = costs.
            groupBy { it.currency }
            .values
            .map { moneys -> moneys.reduce(Money::add) }

        val lines = currencyTotals
            .sortedBy { it.currency.currencyCode }
            .map { exchangeRates.convert(it, userCurrency) }

        val total = lines
            .map { it.toMoney }
            .fold(Money.of(0, userCurrency), Money::add)

        return CostSummary(lines, total)
    }

    fun addCost(cost: Money) {
        currencyTotals.merge(cost.currency, cost, Money::add)
    }

    fun reset() {
        currencyTotals.clear()
    }
}