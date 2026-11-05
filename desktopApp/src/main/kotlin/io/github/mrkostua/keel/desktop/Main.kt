package io.github.mrkostua.keel.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.mrkostua.keel.ui.App

fun main() =
    application {
        Window(onCloseRequest = ::exitApplication, title = "Keel") {
            App()
        }
    }
