package travelator.section19

import dev.forkhandles.result4k.orThrow
import travelator.section19.handlers.RegistrationData

class CustomerRegistration(
	private val customers: Customers,
	private val exclusionList: ExclusionList,
) : IRegisterCustomers {

	@Throws(ExcludedException::class, DuplicateException::class)
	override fun register(data: RegistrationData): Customer {
		return when {
			exclusionList.exclude(data) -> throw ExcludedException()
			else -> customers.add(data.name, data.email).orThrow()
		}
	}
}