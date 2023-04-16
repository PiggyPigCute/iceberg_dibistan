package com.dirtybiologistan.iceberg.discord

val players = CacheCustom() { id: Long -> DiscordUser(id) }

open class DiscordUser(id: Long) {

    var workTime: Long
        private set
    var lastLevelUpdate = 0L

    init {
        workTime = 0
    }

    fun updateWorkTime() {
        workTime = System.currentTimeMillis()
    }
}