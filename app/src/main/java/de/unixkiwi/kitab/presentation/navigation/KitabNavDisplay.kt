package de.unixkiwi.kitab.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import de.unixkiwi.kitab.presentation.editor.EditorScreen
import de.unixkiwi.kitab.presentation.library.LibraryScreen

@Composable
fun KitabNavDisplay(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Library -> NavEntry(key) {
                    LibraryScreen(listOf("Note 1" to "note-1", "Note 2" to "note-2"), onBtnClick = {
                        backStack.add(Editor(it))
                    })
                }

                is Editor -> NavEntry(key) {
                    EditorScreen(key.noteId)
                }

                else -> NavEntry(key) { Text("Unknown route") }
            }
        }
    )
}
