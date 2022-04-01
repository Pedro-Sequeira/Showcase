package com.pedrosequeira.showcase.dashboard

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
internal fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {
    val movies = viewModel.movies.collectAsLazyPagingItems()
    LazyColumn() {
        items(
            items = movies
        ) { movie ->
            if (movie != null) {
                Text(text = movie.title)
            }
        }
    }
}
