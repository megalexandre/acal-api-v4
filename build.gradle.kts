import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "br.com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("jakarta.validation:jakarta.validation-api")

  	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")

	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.data:spring-data-mongodb")

	implementation("ch.qos.logback:logback-classic:1.4.7")
	implementation("io.azam.ulidj:ulidj:1.0.4")
	implementation("com.google.code.gson:gson:2.10.1")


	testImplementation("io.cucumber:cucumber-java:7.2.0")
	testImplementation("io.cucumber:cucumber-junit:7.2.0")
	testImplementation("io.cucumber:cucumber-spring:7.2.0")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")

	testImplementation("io.rest-assured:kotlin-extensions")
	testImplementation("org.springframework.boot:spring-boot-starter-test"){
		exclude(module = "junit")
		exclude(module = "mockito-core")
	}
	testImplementation("io.rest-assured:rest-assured")

	testImplementation("org.springframework.boot:spring-boot-testcontainers")

	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:testcontainers:1.18.1")
	testImplementation("org.testcontainers:mongodb:1.18.1")

	testImplementation("org.mockito:mockito-core")
	testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
	testImplementation("io.mockk:mockk:1.12.2")
	testImplementation("com.github.tomakehurst:wiremock:1.18")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
