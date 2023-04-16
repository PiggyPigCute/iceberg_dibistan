package com.dirtybiologistan.iceberg.discord

import org.javacord.api.interaction.SlashCommandInteraction

interface ExecutableWithArguments {

    val fullName: String

    fun execute(slashCommand: SlashCommandInteraction)

}