package br.com.acalappv4.infrastructure

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class AppAdvice {
	private var logger: Logger = LoggerFactory.getLogger(this::class.java)

	@ExceptionHandler(value = [
		InvalidUsecaseException::class,
	])
	fun e1 (ex: RuntimeException) = ResponseEntity.badRequest().body(
		mapOf(
			"time" to LocalDateTime.now(),
			"message" to ex.message
		)
	)

}