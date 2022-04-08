package com.pedrosequeira.showcase.commons.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

@Composable
fun ScreenWithDialog(
    shouldShowDialog: Boolean,
    text: String,
    screen: @Composable () -> Unit
) {
    Box() {
        AlertDialog(
            shouldShow = shouldShowDialog,
            text = text
        )
        screen.invoke()
    }
}
