package com.dirtybiologistan.iceberg.discord

open class CacheCustom<U>(protected val function: (Long) -> U) {
    private val hashMap = HashMap<Long, U>()
    operator fun get(l: Long): U {
        var u = hashMap[l]
        if (u == null) {
            u = function(l)
            hashMap[l] = u
        }
        return u!!
    }
}
