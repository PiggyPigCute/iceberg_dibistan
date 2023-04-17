package com.dirtybiologistan.iceberg.discord.commands

import com.dirtybiologistan.iceberg.discord.Command
import com.dirtybiologistan.iceberg.discord.ExecutableWithArguments
import com.dirtybiologistan.iceberg.engine.proposals
import org.javacord.api.entity.message.MessageFlag
import org.javacord.api.interaction.SlashCommandInteraction

class HelpCommand : ExecutableWithArguments, Command(
    "help",
    "Affiche l'aide du bot"
) {
    override val fullName: String
        get() = "help"
    override fun execute(slashCommand: SlashCommandInteraction) {
        slashCommand.createImmediateResponder()
            .setContent("Aide du bot. Proposition : " + proposals.random())
            .setFlags(MessageFlag.EPHEMERAL).respond()
    }
}