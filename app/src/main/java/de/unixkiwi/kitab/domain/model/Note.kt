package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Note(
    val id: String,
    val title: String,
    val createdAtMillis: Long,
    val modifiedAtMillis: Long,
    val formatVersion: Int = 1,
    val revision: Long = 0,
    val pages: List<NotePage> = emptyList()
) {
    companion object {
        fun create(
            title: String = "Untitled note",
            pages: List<NotePage> = listOf(NotePage(id = UUID.randomUUID().toString()))
        ): Note {
            val now = System.currentTimeMillis()

            return Note(
                id = UUID.randomUUID().toString(),
                title = title,
                createdAtMillis = now,
                modifiedAtMillis = now,
                pages = pages
            )
        }
    }
}