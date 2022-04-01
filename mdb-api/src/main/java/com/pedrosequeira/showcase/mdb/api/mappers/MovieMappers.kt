package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.data.entities.DataMovie
import com.pedrosequeira.showcase.data.entities.DataPagination
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovie
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination
import com.pedrosequeira.showcase.mdb.api.orFalse
import com.pedrosequeira.showcase.mdb.api.orZero

internal fun ApiPagination.toDataPagination(): DataPagination {
    return DataPagination(
        page = page.orZero(),
        results = results?.map { it.mapToDataMovie() }.orEmpty(),
        totalPages = totalPages.orZero(),
        totalResults = totalResults.orZero()
    )
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
