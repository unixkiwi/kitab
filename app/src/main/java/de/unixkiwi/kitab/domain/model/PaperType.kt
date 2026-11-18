package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class PaperType {
    abstract val bgColorArgb: Long

    @Serializable
    @SerialName("pdf")
    data class PDF(
        val filePath: String,
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()

    @Serializable
    @SerialName("image")
    data class Image(
        val filePath: String,
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()

    @Serializable
    @SerialName("blank")
    data class Blank(
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()

    @Serializable
    @SerialName("grid")
    data class Grid(
        val lineColorArgb: Long,
        val gridSizeX: Double = 5.0,
        val gridSizeY: Double = 5.0,
        val margin: Double = 20.0,
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()

    @Serializable
    @SerialName("dotted")
    data class Dotted(
        val dotColorArgb: Long,
        val dotSize: Double = 1.0,
        val gridSizeX: Double = 5.0,
        val gridSizeY: Double = 5.0,
        val margin: Double = 20.0,
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()

    @Serializable
    @SerialName("ruled")
    data class Ruled(
        val lineColorArgb: Long,
        val lineDistance: Double = 9.0,
        val firstLineDistance: Double = 20.0,
        val margin: Double = 20.0,
        override val bgColorArgb: Long = 0xFFFFFFFFL
    ) : PaperType()
}
