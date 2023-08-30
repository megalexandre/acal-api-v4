package br.com.acalappv4

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestAcalAppV4Application

fun main(args: Array<String>) {
	fromApplication<AcalAppV4Application>().with(TestAcalAppV4Application::class).run(*args)
}
