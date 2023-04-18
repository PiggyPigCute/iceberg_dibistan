package com.dirtybiologistan.iceberg.plugins

import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

val path = Application::class.java.classLoader.getResource("/")

fun Application.configureRouting() {
    routing {
        get("/") {
        }
        get("/index.html") {
            call.respondRedirect("/")
        }
    }
}
