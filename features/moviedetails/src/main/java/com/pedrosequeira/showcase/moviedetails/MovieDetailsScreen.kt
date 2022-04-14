package com.pedrosequeira.showcase.moviedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieDetailsScreen(movieId: Int?) {
    Text(text = movieId.toString())
}
