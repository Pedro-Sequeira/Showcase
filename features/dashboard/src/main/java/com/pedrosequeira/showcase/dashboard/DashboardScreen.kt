package com.pedrosequeira.showcase.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.pedrosequeira.showcase.commons.ui.AlertDialog
import com.pedrosequeira.showcase.dashboard.DashboardState.*
import com.pedrosequeira.showcase.dashboard.widgets.PaginatedItems

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onMovieClick: (movieId: Int) -> Unit
) {

    val movies = viewModel.movies.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        when (val state = handleUiState(movies)) {
            is Data -> PaginatedItems(movies, onMovieClick)
            is Error -> AlertDialog(
                shouldShow = true,
                text = state.errorMessage
            )
            is Loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
