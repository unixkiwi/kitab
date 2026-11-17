package de.unixkiwi.kitab.presentation.editor

import android.graphics.Matrix
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.ink.authoring.compose.InProgressStrokes
import androidx.ink.rendering.android.canvas.CanvasStrokeRenderer
import androidx.ink.strokes.Stroke
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorScreen(
    noteId: String,
    modifier: Modifier = Modifier,
    viewModel: EditorViewModel = koinInject()
) {

    val latestBrush by rememberUpdatedState(viewModel.brush)
    val finishedStrokes = mutableListOf<Stroke>()
    val canvasTransform = remember { Matrix() }
    val canvasStrokeRenderer = remember { CanvasStrokeRenderer.create() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Note", fontWeight = FontWeight.Bold) },
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier
                .padding(innerPadding)
                .fillMaxSize()
                .clipToBounds()
                .background(Color.White)
        ) {
            InProgressStrokes(
                defaultBrush = viewModel.brush,
                nextBrush = { latestBrush },
                onStrokesFinished = { finishedStrokes.addAll(it) }
            )
            Canvas(Modifier.fillMaxSize()) {
                drawContext.canvas.nativeCanvas.concat(canvasTransform)
                finishedStrokes.forEach {
                    canvasStrokeRenderer.draw(
                        stroke = it,
                        canvas = drawContext.canvas.nativeCanvas,
                        strokeToScreenTransform = canvasTransform
                    )
                }
            }
        }
    }
}

