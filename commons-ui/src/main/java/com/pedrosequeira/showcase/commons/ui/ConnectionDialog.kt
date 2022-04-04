package com.pedrosequeira.showcase.commons.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConnectionDialog(show: Boolean) {
    if (show.not()) return
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {},
        text = {
            Text(text = "You have no internet connection")
        }
    )
}
