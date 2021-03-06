package com.pedrosequeira.showcase.data.mappers

import com.pedrosequeira.showcase.core.factories.createUrl
import com.pedrosequeira.showcase.core.formatters.getYearReleaseDate
import com.pedrosequeira.showcase.data.movies.DataMovie
import com.pedrosequeira.showcase.data.movies.DataMovieDetails
import com.pedrosequeira.showcase.domain.movies.Movie
import com.pedrosequeira.showcase.domain.movies.MovieDetails
import javax.inject.Inject

internal class DataMovieMapper @Inject constructor() {

    fun mapToDomainMovieDetails(dataMovieDetails: DataMovieDetails): MovieDetails =
        with(dataMovieDetails) {
            MovieDetails(
                adult = adult,
                backdropPath = backdropPath,
                budget = budget,
                genres = genres.map { it.name },
                homepage = homepage,
                id = id,
                imdbId = imdbId,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                overview = overview,
                popularity = popularity,
                posterPath = posterPath,
                releaseDate = releaseDate,
                revenue = revenue,
                runtime = runtime,
                status = status,
                tagline = tagline,
                title = title,
                video = video,
                voteAverage = voteAverage,
                voteCount = voteCount
            )
        }
}

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
