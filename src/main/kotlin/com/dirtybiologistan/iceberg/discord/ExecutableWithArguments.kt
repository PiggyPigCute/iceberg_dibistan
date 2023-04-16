package com.dirtybiologistan.iceberg.discord

import org.javacord.api.interaction.SlashCommandInteraction

interface ExecutableWithArguments {

    val fullName: String
    val botPerms: Array<String>?

    fun execute(slashCommand: SlashCommandInteraction)

}