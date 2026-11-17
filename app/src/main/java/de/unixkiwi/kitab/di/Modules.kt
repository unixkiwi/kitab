package de.unixkiwi.kitab.di

import de.unixkiwi.kitab.presentation.editor.EditorViewModel
import org.koin.dsl.module

val appModule = module {
    single {
        EditorViewModel()
    }
}