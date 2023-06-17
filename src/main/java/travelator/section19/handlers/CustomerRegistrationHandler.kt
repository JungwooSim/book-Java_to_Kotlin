package travelator.section19.handlers

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import dev.forkhandles.result4k.map
import dev.forkhandles.result4k.recover
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_CONFLICT
import java.net.HttpURLConnection.HTTP_CREATED
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import travelator.section19.Duplicate
import travelator.section19.Excluded
import travelator.section19.IRegisterCustomers
import travelator.section19.RegistrationProblem
import travelator.section19.http.Request
import travelator.section19.http.Response

class CustomerRegistrationHandler(
	private val registration: IRegisterCustomers
) {
	private val objectMapper = ObjectMapper()

	fun handle(request: Request): Response {
		return try {
			val data = objectMapper.readValue(
				request.body,
				RegistrationData::class.java
			)

			registration.registerToo(data).map { value ->
				Response(
					HTTP_CREATED,
					objectMapper.writeValueAsString(value)
				)
			}.recover { reason -> reason.toResponse() }

		} catch (x: JsonProcessingException) {
			Response(HTTP_BAD_REQUEST)
		} catch (x: Exception) {
			Response(HTTP_INTERNAL_ERROR)
		}
	}

	private fun RegistrationProblem.toResponse() = when (this) {
		is Duplicate -> Response(HTTP_CONFLICT)
		is Excluded -> Response(HTTP_FORBIDDEN)
	}
}