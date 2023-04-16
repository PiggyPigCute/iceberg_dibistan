package com.dirtybiologistan.iceberg.discord

import com.dirtybiologistan.iceberg.api
import org.javacord.api.entity.permission.PermissionType
import org.javacord.api.interaction.SlashCommand
import org.javacord.api.interaction.SlashCommandOption
import java.util.*

open class Command(
    val name: String,
    val description: String,
    discordPerms: EnumSet<PermissionType>? = null, // les permissions de discord sont automatiques, différentes de celles du bot
    inDms: Boolean = true, // discord permet d´interdire les dm
    arguments: ArrayList<SlashCommandOption> = arrayListOf()
) {
    init {
        if (this is ExecutableWithArguments) {
            commands[fullName] = this
        }
        if (discordPerms == null) {
            SlashCommand.with(name, description)
                .setEnabledInDms(inDms)
                .createGlobal(api)
                .join()
        } else {
            SlashCommand.with(name, description)
                .setEnabledInDms(inDms)
                .setDefaultEnabledForPermissions(discordPerms)
                .createGlobal(api)
                .join()
        }
    }
}
