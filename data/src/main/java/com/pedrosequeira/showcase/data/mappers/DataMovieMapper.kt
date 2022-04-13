package com.pedrosequeira.showcase.data.mappers

import com.pedrosequeira.showcase.core.factories.createUrl
import com.pedrosequeira.showcase.core.formatters.getYearReleaseDate
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
        posterPath = createUrl(posterPath),
        releaseDate = releaseDate.getYearReleaseDate(),
        title = title,
        hasVideo = hasVideo,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
