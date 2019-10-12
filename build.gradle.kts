import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jobjCoreVersion by extra("3.2.1")
val mapstructVersion by extra("1.3.0.Final")
val entCoreVersion by extra("1.7.1")
val springToolExtensionsVersion by extra("1.4")

plugins {
	id("org.springframework.boot") version "2.1.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"
	kotlin("plugin.jpa") version "1.2.71"
}

group = "de.alpharogroup"
version = "1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	compile("io.github.microutils:kotlin-logging:1.3.2")
	compile("org.mapstruct:mapstruct:$mapstructVersion")
	compileOnly("org.mapstruct:mapstruct-processor:$mapstructVersion")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	compile("de.alpharogroup:ent-core:$entCoreVersion")
	compile("de.alpharogroup:jobj-core:$jobjCoreVersion")
	compile("javax.xml.bind:jaxb-api:2.3.0")
	compile("de.alpharogroup:spring-tool-extensions:$springToolExtensionsVersion")
	implementation("org.postgresql:postgresql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
