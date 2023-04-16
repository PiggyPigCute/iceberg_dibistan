package com.dirtybiologistan.iceberg

import com.dirtybiologistan.iceberg.discord.ListenerSlashCommands
import com.dirtybiologistan.iceberg.discord.loadAllCommands
import com.dirtybiologistan.iceberg.plugins.configureRouting
import com.dirtybiologistan.iceberg.plugins.configureSerialization
import com.dirtybiologistan.iceberg.plugins.configureSockets
import com.dirtybiologistan.iceberg.plugins.configureTemplating
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder
import org.javacord.api.entity.intent.Intent
import kotlin.concurrent.thread

val api: DiscordApi = DiscordApiBuilder()
    .setToken(System.getenv("token_iceberg"))
    .addIntents(Intent.MESSAGE_CONTENT)
    .login().join()

fun main() {
    println("Hello, world!")
    println("Plouf, l'iceberg est là !")

    thread {
        api.updateActivity("Les votes sont en cours ! Utilisez /vote pour voter !")
        api.addListener(ListenerSlashCommands())
        loadAllCommands()
    }

    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    configureTemplating()
    configureRouting()
}
