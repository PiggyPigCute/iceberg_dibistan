package com.dirtybiologistan.iceberg.plugins

import com.dirtybiologistan.iceberg.engine.proposals
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
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
        staticResources("/static", "static") {
        }
        get("/ask") {
            call.respond(FreeMarkerContent("vote.ftl", mapOf(
                "data" to IndexData(listOf(1, 2, 3)),
                "prop0" to proposals.random(),
                "prop1" to proposals.random()
            ), ""))
        }
        get("/vote") {
            call.respondRedirect("/ask")
        }
    }
}
