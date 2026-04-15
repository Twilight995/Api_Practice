import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.11"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "com.daelim"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    // spring
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // swagger-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // graphql
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // util
    implementation("net.datafaker:datafaker:2.1.0")
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