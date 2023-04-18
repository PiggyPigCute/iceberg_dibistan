package com.dirtybiologistan.iceberg.discord.commands

import com.dirtybiologistan.iceberg.discord.Command
import com.dirtybiologistan.iceberg.discord.ExecutableWithArguments
import org.javacord.api.interaction.SlashCommandInteraction

class VoteCommand : Command(
    "vote",
    "Permet de voter pour les propositions de l'iceberg. 2 propositions seront choisies aléatoirement."
), ExecutableWithArguments {
    override val fullName: String
        get() = "vote"

    override fun execute(slashCommand: SlashCommandInteraction) {
        TODO("Not yet implemented")
    }
}