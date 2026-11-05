package io.github.mrkostua.keel.shared

actual fun platformName(): String = "Desktop (${System.getProperty("os.name")})"
