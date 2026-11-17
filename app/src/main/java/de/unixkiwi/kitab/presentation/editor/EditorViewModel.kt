package de.unixkiwi.kitab.presentation.editor

import androidx.compose.ui.graphics.Color
import androidx.ink.brush.Brush
import androidx.ink.brush.StockBrushes
import androidx.ink.brush.compose.createWithComposeColor
import androidx.lifecycle.ViewModel

class EditorViewModel : ViewModel() {
    val brush = Brush.createWithComposeColor(
        family = StockBrushes.pressurePen(),
        color = Color.Black,
        size = 5F,
        epsilon = 0.1F
    )
}