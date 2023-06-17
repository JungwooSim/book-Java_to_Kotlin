package travelator.section19

import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Result
import dev.forkhandles.result4k.Success
import travelator.section19.handlers.RegistrationData
import kotlin.jvm.Throws

sealed class RegistrationProblem

object Excluded : RegistrationProblem()

data class Duplicate(
	val message: String?,
) : RegistrationProblem()

interface IRegisterCustomers {

	@Throws(ExcludedException::class, DuplicateException::class)
	fun register(data: RegistrationData): Customer

	fun registerToo(data: RegistrationData): Result<Customer, RegistrationProblem> =
		try {
			Success(register(data))
		} catch (x: ExcludedException) {
			Failure(Excluded)
		} catch (x: DuplicateException) {
			Failure(Duplicate(x.message))
		}
}