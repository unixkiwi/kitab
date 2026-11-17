package de.unixkiwi.kitab.presentation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import de.unixkiwi.kitab.presentation.navigation.KitabNavDisplay
import de.unixkiwi.kitab.presentation.navigation.Library

@Composable
fun KitabApp(backStack: NavBackStack<NavKey> = rememberNavBackStack(Library)) {
    KitabNavDisplay(backStack = backStack)
}