package com.pedrosequeira.showcase.dashboard

import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.pedrosequeira.showcase.domain.movies.Movie

internal fun handleUiState(state: LazyPagingItems<Movie>): DashboardState {
    return when (val refreshState = state.loadState.refresh) {
        is LoadState.Error -> {
            val errorMessage = refreshState.error.localizedMessage
            DashboardState.Error(errorMessage ?: "unknown error")
        }
        is LoadState.NotLoading -> {
            DashboardState.Data(state)
        }
        else -> DashboardState.Loading
    }
}
