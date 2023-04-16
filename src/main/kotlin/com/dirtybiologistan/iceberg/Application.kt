package com.dirtybiologistan.iceberg

import com.dirtybiologistan.iceberg.plugins.configureRouting
import com.dirtybiologistan.iceberg.plugins.configureSerialization
import com.dirtybiologistan.iceberg.plugins.configureSockets
import com.dirtybiologistan.iceberg.plugins.configureTemplating
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import org.javacord.api.DiscordApiBuilder
import org.javacord.api.entity.intent.Intent


fun main() {
    println("Hello, world!")
    println("Plouf, l'iceberg est là !")

    println(System.getenv("token_iceberg"))

    val api = DiscordApiBuilder()
        .setToken(System.getenv("token_iceberg"))
        .addIntents(Intent.MESSAGE_CONTENT)
        .login().join()

    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    configureTemplating()
    configureRouting()
}
