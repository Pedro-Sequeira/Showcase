package com.pedrosequeira.showcase.moviedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pedrosequeira.showcase.core.formatters.formatRunTime
import com.pedrosequeira.showcase.core.formatters.getYearReleaseDate
import com.pedrosequeira.showcase.domain.movies.MovieDetails

@Composable
fun MovieDetails(
) {
    MovieDetailsScreen()
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
private fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value
    if (state.movieDetails != null) {
        MovieDetails(state.movieDetails)
    }
    if (state.errorMessage != null) {
        ErrorDetails(state.errorMessage)
    }
}

@Composable
private fun MovieDetails(movie: MovieDetails) {
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

@Composable
private fun ErrorDetails(errorMessage: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = errorMessage,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}
