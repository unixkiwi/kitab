package de.unixkiwi.kitab.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class NotePage(
    val id: String,
    val size: PaperSize = PaperSize.A4,
    val type: PaperType = PaperType.Blank(),
    val items: List<PageItem> = emptyList(),
)
