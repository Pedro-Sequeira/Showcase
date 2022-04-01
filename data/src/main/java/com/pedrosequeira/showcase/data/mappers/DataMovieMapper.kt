package com.pedrosequeira.showcase.data.mappers

import com.pedrosequeira.showcase.data.entities.DataMovie
import com.pedrosequeira.showcase.domain.entities.Movie

internal fun DataMovie.toMovie(): Movie {
    return Movie(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        hasVideo = hasVideo,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
