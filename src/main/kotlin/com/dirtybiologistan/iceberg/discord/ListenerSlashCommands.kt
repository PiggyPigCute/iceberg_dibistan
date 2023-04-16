package com.dirtybiologistan.iceberg.discord

import org.javacord.api.entity.message.MessageFlag
import org.javacord.api.event.interaction.SlashCommandCreateEvent
import org.javacord.api.listener.interaction.SlashCommandCreateListener

val commands = LinkedHashMap<String, ExecutableWithArguments>()

fun loadAllCommands() {
    println("Loaded ${commands.size} commands")
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
            if (executableWithArguments.botPerms == null) {
                executableWithArguments.execute(slashCommand)
            } else if (executableWithArguments.botPerms!!.isEmpty()) {
                executableWithArguments.execute(slashCommand)
            } else {
                throw IllegalStateException("Vous n'avez pas les permissions pour utiliser cette commande")
            }
        } catch (e: Exception) {
            slashCommand.createImmediateResponder()
                .setContent("Une erreur est survenue. Vérifiez le contenu de la commande. Erreur = `${e.localizedMessage}`")
                .setFlags(MessageFlag.EPHEMERAL).respond()
            e.printStackTrace()
        }
    }
}