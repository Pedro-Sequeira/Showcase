package com.pedrosequeira.showcase.data.usecases

import com.pedrosequeira.domain.entities.IOResult
import com.pedrosequeira.domain.entities.Movie
import com.pedrosequeira.domain.entities.Pagination
import com.pedrosequeira.domain.entities.map
import com.pedrosequeira.domain.usecases.GetTopRatedMoviesUseCase
import com.pedrosequeira.showcase.data.MoviesDataStores
import com.pedrosequeira.showcase.data.entities.DataMovie
import com.pedrosequeira.showcase.data.entities.DataPagination
import javax.inject.Inject

internal class GetTopRatedMoviesUseCaseImpl @Inject constructor(
    private val moviesDataStores: MoviesDataStores
) : GetTopRatedMoviesUseCase {

    override suspend fun getTopRatedMovies(page: Int): IOResult<Pagination> {
        return moviesDataStores.remote.getTopRatedMovies(page).map {
            it.toPagination()
        }
    }
}

private fun DataPagination.toPagination(): Pagination {
    return Pagination(
        page = page,
        results = results.map { it.toMovie() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun DataMovie.toMovie(): Movie {
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
