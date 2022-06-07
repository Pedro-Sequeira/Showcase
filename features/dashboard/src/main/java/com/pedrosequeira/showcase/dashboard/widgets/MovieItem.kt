package com.pedrosequeira.showcase.dashboard.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pedrosequeira.showcase.commons.ui.MovieCover
import com.pedrosequeira.showcase.domain.movies.Movie

@Composable
internal fun MovieItem(movie: Movie, onMovieClick: (movieId: Int) -> Unit) {
    Row(
        modifier = Modifier
            .clickable {
                onMovieClick.invoke(movie.id)
            }
            .height(150.dp)
            .padding(8.dp),
    ) {
        MovieCover(url = movie.posterPath)
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = movie.title)
            Text(text = movie.releaseDate)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color(0xffc2712b),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = movie.voteAverage.toString())
            }
        }
    }
}
