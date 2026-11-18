package de.unixkiwi.kitab

import de.unixkiwi.kitab.domain.model.Note
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

// First test! yay, maybe I'll do more tests this project... Probably the last test of this proj...
class NoteDocumentTest {

    private val json = Json {
        prettyPrint = true
        classDiscriminator = "itemType"
    }

    @Test
    fun documentCanBeSerializedAndRestored() {
        val original = Note.create("Physics notes")

        val encoded = json.encodeToString(original)
        val restored = json.decodeFromString<Note>(encoded)

        assertEquals(original.id, restored.id)
        assertEquals(original.title, restored.title)
        assertEquals(original.pages.size, restored.pages.size)
        assertEquals(original.pages.first().size, restored.pages.first().size)
    }
}