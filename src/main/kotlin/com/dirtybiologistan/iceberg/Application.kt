package com.dirtybiologistan.iceberg

import com.dirtybiologistan.iceberg.plugins.configureRouting
import com.dirtybiologistan.iceberg.plugins.configureSerialization
import com.dirtybiologistan.iceberg.plugins.configureSockets
import com.dirtybiologistan.iceberg.plugins.configureTemplating
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*

fun main() {
    println("Hello, world!")
    println("Plouf, l'iceberg est là !")

    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    configureTemplating()
    configureRouting()
}
