package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.data.entities.commons.DataPagination
import com.pedrosequeira.showcase.data.entities.movies.DataMovie
import com.pedrosequeira.showcase.data.entities.movies.DataMovieDetails
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovie
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovieDetails
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination
import com.pedrosequeira.showcase.mdb.api.extensions.orFalse
import com.pedrosequeira.showcase.mdb.api.extensions.orZero

internal fun ApiPagination.toDataPagination(): DataPagination {
    return DataPagination(
        page = page.orZero(),
        results = results?.map { it.mapToDataMovie() }.orEmpty(),
        totalPages = totalPages.orZero(),
        totalResults = totalResults.orZero()
    )
}

internal fun ApiMovieDetails.toDataMovieDetails(): DataMovieDetails {
    return DataMovieDetails(
        adult = adult.orFalse(),
        backdropPath = backdropPath.orEmpty(),
        budget = budget.orZero(),
        genres = genres.mapGenres(),
        homepage = homepage.orEmpty(),
        id = id.orZero(),
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue.orZero(),
        runtime = runtime.orZero(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video.orFalse(),
        voteAverage = voteAverage.orZero(),
        voteCount = voteCount.orZero()
    )
}

private fun List<ApiMovieDetails.ApiGenre>?.mapGenres(): List<DataMovieDetails.Genre> {
    return this?.map {
        DataMovieDetails.Genre(
            it.id.orZero(),
            it.name.orEmpty()
        )
    } ?: emptyList()
}

private fun ApiMovie.mapToDataMovie(): DataMovie {
    return DataMovie(
        adult = adult.orFalse(),
        backdropPath = backdropPath.orEmpty(),
        genreIds = genreIds.orEmpty(),
        id = id.orZero(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        hasVideo = hasVideo.orFalse(),
        voteAverage = voteAverage.orZero(),
        voteCount = voteCount.orZero()
    )
}
