val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.20"
    id("io.ktor.plugin") version "2.2.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.20"
}

group = "com.dirtybiologistan.iceberg"
version = "0.0.1"
application {
    mainClass.set("com.dirtybiologistan.iceberg.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core-jvm:2.3.1")
    implementation("io.ktor:ktor-server-websockets-jvm:2.3.1")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.1")
    implementation("io.ktor:ktor-server-host-common-jvm:2.3.1")
    implementation("io.ktor:ktor-server-freemarker-jvm:2.3.1")
    implementation("io.ktor:ktor-server-tomcat-jvm:2.3.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("org.javacord:javacord:3.8.0")
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.1")
}