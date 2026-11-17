package de.unixkiwi.kitab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.rememberNavBackStack
import de.unixkiwi.kitab.presentation.navigation.KitabNavDisplay
import de.unixkiwi.kitab.presentation.navigation.Library
import de.unixkiwi.kitab.presentation.theme.KitabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KitabTheme {
                val backStack = rememberNavBackStack(Library)
                KitabNavDisplay(backStack)
            }
        }
    }
}
