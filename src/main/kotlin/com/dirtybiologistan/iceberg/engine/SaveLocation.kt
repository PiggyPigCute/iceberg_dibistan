package com.dirtybiologistan.iceberg.engine

import java.util.*

/**
 * @param E type of content, think to add a toString() method in E!
 */
class SaveLocation<E>(private val sep: String, private val path: String, val a: (String) -> E) {
    var content = ArrayList<E>()

    fun loadAll() {
        val stream = SaveLocation::class.java.classLoader.getResourceAsStream(path)
        if (stream == null) {
            content = ArrayList<E>()
        } else {
            val sc = Scanner(stream)
            var answer = ""
            while (sc.hasNextLine()) {
                answer += sc.nextLine()
                if (sc.hasNextLine()) answer += "\n"
            }
            val str = answer.split(sep.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (s in str) {
                content.add(a(s))
            }
        }
    }
}