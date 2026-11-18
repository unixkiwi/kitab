package de.unixkiwi.kitab

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toColorLong
import de.unixkiwi.kitab.domain.model.BrushData
import de.unixkiwi.kitab.domain.model.BrushType
import de.unixkiwi.kitab.domain.model.Note
import de.unixkiwi.kitab.domain.model.NotePage
import de.unixkiwi.kitab.domain.model.Point
import de.unixkiwi.kitab.domain.model.StrokeData
import de.unixkiwi.kitab.domain.model.StrokeItem
import de.unixkiwi.kitab.domain.model.StrokePoint
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.UUID

// First test! yay, maybe I'll do more tests this project... Probably the last test of this proj...
class NoteDocumentTest {

    private val json = Json {
        prettyPrint = true
        classDiscriminator = "itemType"
    }

    @Test
    fun documentCanBeSerializedAndRestored() {
        val pages = listOf(
            NotePage(
                id = UUID.randomUUID().toString(), items = listOf(
                    StrokeItem(
                        UUID.randomUUID().toString(),
                        StrokeData(
                            brush = BrushData(
                                BrushType.BALL_PEN,
                                Color.Black.toColorLong(),
                                2.0
                            ),
                            points = listOf(
                                StrokePoint(
                                    Point(1.0, 1.0),
                                    pressure = 1f,
                                    elapsedTimeMicros = 12
                                ),
                                StrokePoint(
                                    Point(2.0, 5.0),
                                    pressure = 0.78f,
                                    elapsedTimeMicros = 19
                                )
                            )
                        )
                    )
                )
            )
        )
        val original = Note.create("Physics notes", pages)

        val encoded = json.encodeToString(original)
        val restored = json.decodeFromString<Note>(encoded)

        assertEquals(original.id, restored.id)
        assertEquals(original.title, restored.title)
        assertEquals(original.pages.size, restored.pages.size)
        assertEquals(original.pages.first().size, restored.pages.first().size)
        assertEquals(original.pages.first().items.first(), restored.pages.first().items.first())
    }
}