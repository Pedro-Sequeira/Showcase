package com.pedrosequeira.showcase.domain.tests

import com.pedrosequeira.showcase.domain.movies.MovieDetails

val MovieDetails.Companion.EMPTY
    get() = MovieDetails(
        adult = false,
        backdropPath = "",
        budget = 0,
        genres = listOf(),
        homepage = "",
        id = 0,
        imdbId = "",
        originalLanguage = "",
        originalTitle = "",
        overview = "",
        popularity = 0.0,
        posterPath = "",
        releaseDate = "",
        revenue = 0,
        runtime = 0,
        status = "",
        tagline = "",
        title = "",
        video = false,
        voteAverage = 0.0,
        voteCount = 0
    )
