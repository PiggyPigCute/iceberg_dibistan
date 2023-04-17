package com.dirtybiologistan.iceberg.discord

import com.dirtybiologistan.iceberg.discord.commands.HelpCommand
import org.javacord.api.entity.message.MessageFlag
import org.javacord.api.event.interaction.SlashCommandCreateEvent
import org.javacord.api.listener.interaction.SlashCommandCreateListener

val commands = LinkedHashMap<String, ExecutableWithArguments>()

fun loadAllCommands() {
    HelpCommand()
    println("Loaded ${commands.size} commands")
    for (command in commands) {
        println("Loaded command ${command.key}")
    }
}

class ListenerSlashCommands : SlashCommandCreateListener {
    override fun onSlashCommandCreate(event: SlashCommandCreateEvent) {
        val slashCommand = event.slashCommandInteraction
        try {
            var commandName = slashCommand.commandName
            // on prend les arguments pour trouver les sous commandes
            val arguments = slashCommand.options
            for (arg in arguments) {
                if (arg.isSubcommandOrGroup) {
                    commandName += " " + arg.name
                    val options = arg.options
                    for (option in options) {
                        if (option.isSubcommandOrGroup) {
                            commandName += " " + option.name
                        }
                    }
                }
            }
            val executableWithArguments = commands[commandName]
                ?: throw IllegalStateException("Commande inconnue \"${commandName}\"")
            executableWithArguments.execute(slashCommand)
        } catch (e: Exception) {
            slashCommand.createImmediateResponder()
                .setContent("Une erreur est survenue. Vérifiez le contenu de la commande. Erreur = `${e.localizedMessage}`")
                .setFlags(MessageFlag.EPHEMERAL).respond()
            e.printStackTrace()
        }
    }
}