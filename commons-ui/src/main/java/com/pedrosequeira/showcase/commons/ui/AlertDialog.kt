package com.pedrosequeira.showcase.commons.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AlertDialog(shouldShow: Boolean, text: String) {
    if (shouldShow.not()) return
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {},
        text = {
            Text(text)
        }
    )
}
