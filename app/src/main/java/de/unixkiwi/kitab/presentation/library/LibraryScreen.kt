package de.unixkiwi.kitab.presentation.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    notes: List<Pair<String, String>>,
    onBtnClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        Column(
            modifier.padding(innerPadding)
        ) {
            for (note in notes) {
                Button(
                    onClick = { onBtnClick(note.second) }
                ) {
                    Text(note.first)
                }
            }
        }
    }
}