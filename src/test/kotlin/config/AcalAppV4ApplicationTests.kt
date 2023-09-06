package config

import br.com.acalappv4.AcalAppV4Application
import br.com.acalappv4.adapter.LocalDateTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.restassured.RestAssured
import java.time.LocalDate
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.TestPropertySource
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [AcalAppV4Application::class])
@ComponentScan(basePackageClasses = [AcalAppV4Application::class])
@TestPropertySource("classpath:application.yml")
class AcalAppV4ApplicationTests {

	companion object {
		private const val USERNAME = "root"
		private const val PASSWORD = "example"

		@Container
		val mongoContainer: GenericContainer<*> = GenericContainer<Nothing>("mongo:4.0.10").apply {
			withExposedPorts(27017)
			withEnv("MONGO_INITDB_ROOT_USERNAME", USERNAME)
			withEnv("MONGO_INITDB_ROOT_PASSWORD", PASSWORD)
		}

		@BeforeAll
		@JvmStatic
		fun setUp() {
			mongoContainer.start()
		}

		@DynamicPropertySource
		@JvmStatic
		fun properties(registry: DynamicPropertyRegistry) {
			registry.add("spring.data.mongodb.uri") {
				"mongodb://${USERNAME}:${PASSWORD}@${mongoContainer.host}:${
					mongoContainer.getMappedPort(
						27017
					)
				}/"
			}
		}
	}


	@LocalServerPort
	private var serverPort = -1;

	@BeforeEach
	fun setup(){
		RestAssured.port = serverPort
	}

	val gson: Gson = GsonBuilder()
		.registerTypeAdapter(LocalDate::class.java, LocalDateTypeAdapter())
		.create()

}
