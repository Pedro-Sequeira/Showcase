package com.pedrosequeira.showcase.moviedetails

import com.pedrosequeira.showcase.domain.movies.MovieDetails

data class MovieDetailsState(
    val movieDetails: MovieDetails? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)
