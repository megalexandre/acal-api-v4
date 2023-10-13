package config

import br.com.acalappv4.AcalAppV4Application
import br.com.acalappv4.adapter.LocalDateTimeTypeAdapter
import br.com.acalappv4.adapter.LocalDateTypeAdapter
import br.com.acalappv4.resource.repository.CustomerRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.LocalDate
import java.time.LocalDateTime

@Testcontainers
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [AcalAppV4Application::class])
@ComponentScan(basePackageClasses = [AcalAppV4Application::class])
class AcalAppV4ApplicationTests {

	@Autowired
	private lateinit var customerRepository: CustomerRepository

	companion object {
		private const val USERNAME = "root"
		private const val PASSWORD = "example"

		@Container
		val mongoContainer: GenericContainer<*> = GenericContainer<Nothing>("mongo:4.0.10").apply {
			withExposedPorts(27017)
			withReuse(true)
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
		resetDatabase()
	}

	fun resetDatabase(){
		customerRepository.deleteAll()
	}

	val gson: Gson = GsonBuilder()
		.registerTypeAdapter(LocalDate::class.java, LocalDateTypeAdapter())
		.registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
		.create()

}
