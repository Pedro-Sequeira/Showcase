package com.pedrosequeira.showcase.dashboard.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.pedrosequeira.showcase.domain.movies.Movie

@Composable
internal fun PaginatedItems(
    movies: LazyPagingItems<Movie>,
    onMovieClick: (movieId: Int) -> Unit
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
    ) {
        items(items = movies) { movie ->
            if (movie != null) {
                MovieItem(movie, onMovieClick)
            } else {
                Placeholder()
            }
            Divider(
                thickness = 0.5.dp
            )
        }
    }
}
