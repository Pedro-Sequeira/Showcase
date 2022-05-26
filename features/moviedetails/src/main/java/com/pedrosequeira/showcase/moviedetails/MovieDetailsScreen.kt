package com.pedrosequeira.showcase.moviedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrosequeira.showcase.core.formatters.formatRunTime
import com.pedrosequeira.showcase.core.formatters.getYearReleaseDate
import com.pedrosequeira.showcase.domain.entities.movies.MovieDetails

@Composable
fun MovieDetails(
) {
    MovieDetailsScreen()
}

@Composable
private fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is MovieDetailsState.Loading -> Unit
        is MovieDetailsState.Data -> MovieDetails(state.details)
        is MovieDetailsState.Error -> Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = state.message,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun MovieDetails(movie: MovieDetails) {
    Column {
        Text(text = movie.title)
        Text(text = movie.releaseDate.getYearReleaseDate())
        Text(text = movie.runtime.formatRunTime())
        Row {
            movie.genres.map {
                Text(it)
            }
        }
    }
}
