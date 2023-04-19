package com.dirtybiologistan.iceberg.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

val index = Application::class.java.classLoader.getResource("static/index.html")
    ?: throw Exception("index.html not found")

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondFile(File(index.toURI()))
        }
        get("/index.html") {
            call.respondRedirect("/")
        }
        static("/static") {
            resources("static")
        }
    }
}
