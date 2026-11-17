package de.unixkiwi.kitab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.unixkiwi.kitab.presentation.KitabApp
import de.unixkiwi.kitab.presentation.theme.KitabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KitabTheme {
                KitabApp()
            }
        }
    }
}
