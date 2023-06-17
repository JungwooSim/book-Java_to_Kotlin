package travelator.section19

import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Result
import dev.forkhandles.result4k.Success
import java.util.*
import kotlin.collections.ArrayList

class InMemoryCustomers : Customers {

	private val list: MutableList<Customer> = ArrayList()
	private var id = 0

	override fun add(name: String, email: String): Result<Customer, DuplicateException> =
		when {
			list.any { it.email == email} -> Failure(
				DuplicateException("customer with eamil $email already exists")
			)
			else -> {
				val result = Customer(id++.toString(), name, email)
				list.add(result)
				Success(result)
			}
		}

	override fun find(id: String): Optional<Customer> =
		list.firstOrNull {it.id == id}.toOptional()
}
