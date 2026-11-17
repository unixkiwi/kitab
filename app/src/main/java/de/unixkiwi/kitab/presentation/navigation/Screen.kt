package de.unixkiwi.kitab.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Library : NavKey

@Serializable
data class Editor(val noteId: String) : NavKey