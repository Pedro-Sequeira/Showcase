package com.pedrosequeira.showcase.moviedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieDetails(
    movieId: Int?
) {
    movieId?.let {
        MovieDetailsScreen(it)
    }
}

@Composable
private fun MovieDetailsScreen(
    movieId: Int,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    viewModel.getMovieDetails(movieId)

    when (val state = viewModel.uiState.collectAsState().value) {
        is MovieDetailsState.Loading -> Unit
        is MovieDetailsState.Data -> Text(text = state.details.title)
    }
}
