package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.Serializable

@Serializable
enum class BrushType {
    BALL_PEN,
    FOUNTAIN_PEN,
    HIGHLIGHTER
}

@Serializable
data class BrushData(
    val type: BrushType,
    val colorArgb: Long,
    val size: Double,
    val opacity: Float = 1f,
    val pressureSensitive: Boolean = true
)

@Serializable
data class StrokePoint(
    val position: Point,
    val pressure: Float,
    val elapsedTimeMicros: Long
)

@Serializable
data class StrokeData(
    val brush: BrushData,
    val points: List<StrokePoint>
)
