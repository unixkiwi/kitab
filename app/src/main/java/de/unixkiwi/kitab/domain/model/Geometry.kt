package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.Serializable
import kotlin.math.max
import kotlin.math.min

@Serializable
data class Point(
    val x: Double,
    val y: Double
)

@Serializable
data class Rect(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
)

@Serializable
data class PaperSize(
    val widthMm: Double,
    val heightMm: Double
) {
    companion object {
        val A4 = PaperSize(210.0, 297.0)
    }

    fun flipOrientation(): PaperSize {
        return PaperSize(widthMm = heightMm, heightMm = widthMm)
    }

    fun landscape(): PaperSize {
        return PaperSize(widthMm = max(heightMm, widthMm), heightMm = min(heightMm, widthMm))
    }

    fun portrait(): PaperSize {
        return PaperSize(widthMm = min(heightMm, widthMm), heightMm = max(heightMm, widthMm))
    }
}
