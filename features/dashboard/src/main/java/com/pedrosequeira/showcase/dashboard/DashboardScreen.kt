package com.pedrosequeira.showcase.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.pedrosequeira.showcase.commons.ui.AlertDialog
import com.pedrosequeira.showcase.dashboard.widgets.PaginatedItems

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onMovieClick: (movieId: Int) -> Unit
) {

    val movies = viewModel.movies.collectAsLazyPagingItems()

    Box {
        when (val state = handleUiState(movies)) {
            is DashboardState.Data -> PaginatedItems(movies, onMovieClick)
            is DashboardState.Error -> AlertDialog(
                shouldShow = true,
                text = state.errorMessage
            )
            DashboardState.Loading -> CircularProgressIndicator()
        }
    }
}
