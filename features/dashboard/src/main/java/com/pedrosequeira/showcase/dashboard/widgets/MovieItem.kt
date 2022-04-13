package com.pedrosequeira.showcase.dashboard.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pedrosequeira.showcase.commons.ui.MovieCover
import com.pedrosequeira.showcase.domain.entities.Movie

@Composable
internal fun MovieItem(movie: Movie) {
    Row() {
        MovieCover(
            modifier = Modifier
                .height(80.dp),
            url = movie.posterPath
        )
        Column() {
            Text(text = movie.title)
            Text(text = movie.releaseDate)
            Text(text = movie.voteAverage.toString())
        }
    }
}
