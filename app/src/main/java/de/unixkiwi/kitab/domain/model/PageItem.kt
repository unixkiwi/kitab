package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface PageItem {
    val id: String
}

@Serializable
@SerialName("stroke")
data class StrokeItem(
    override val id: String,
    val stroke: StrokeData
) : PageItem

@Serializable
@SerialName("image")
data class ImageItem(
    override val id: String,
    val assetId: String,
    val bounds: Rect,
    val rotationDegrees: Float = 0f
) : PageItem

@Serializable
enum class ShapeType {
    CIRCLE,
    POLYGON
}

@Serializable
@SerialName("shape")
data class ShapeItem(
    override val id: String,
    val type: ShapeType,
    val points: List<Point>,
    val colorArgb: Long,
    val strokeWidth: Double
) : PageItem