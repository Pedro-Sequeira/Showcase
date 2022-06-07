package com.pedrosequeira.showcase.dashboard

import androidx.paging.compose.LazyPagingItems
import com.pedrosequeira.showcase.domain.movies.Movie

internal sealed class DashboardState {

    object Loading : DashboardState()

    data class Data(val data: LazyPagingItems<Movie>) : DashboardState()

    data class Error(val errorMessage: String): DashboardState()
}
