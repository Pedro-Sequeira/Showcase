package com.pedrosequeira.showcase.commons.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieCover(
    modifier: Modifier,
    url: String
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest
            .Builder(LocalContext.current)
            .data(url)
            .build(),
        contentDescription = null
    )
}
