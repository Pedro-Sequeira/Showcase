package com.pedrosequeira.showcase.dashboard.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pedrosequeira.showcase.domain.entities.Movie

@Composable
internal fun MovieItem(movie: Movie) {
    Text(text = movie.title)
}
