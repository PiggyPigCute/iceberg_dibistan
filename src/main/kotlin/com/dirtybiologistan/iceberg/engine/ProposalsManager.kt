package com.dirtybiologistan.iceberg.engine

val proposals = run {
    val save = SaveLocation("\n", "propositions/Iceberg.txt") { it }
    save.loadAll()
    save.content
}

class ProposalsManager {

}