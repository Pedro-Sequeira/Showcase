package com.pedrosequeira.showcase.moviedetails

import com.pedrosequeira.showcase.domain.entities.movies.MovieDetails

internal sealed class MovieDetailsState {

    object Loading : MovieDetailsState()

    data class Data(val details: MovieDetails): MovieDetailsState()

    data class Error(val message: String): MovieDetailsState()
}
