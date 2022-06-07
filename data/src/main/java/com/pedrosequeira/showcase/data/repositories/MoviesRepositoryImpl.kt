package com.pedrosequeira.showcase.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.michaelbull.result.mapEither
import com.pedrosequeira.showcase.data.datastores.MoviesDataStores
import com.pedrosequeira.showcase.data.mappers.DataMovieMapper
import com.pedrosequeira.showcase.data.mappers.ErrorMapper
import com.pedrosequeira.showcase.data.paging.MoviePagingSource
import com.pedrosequeira.showcase.domain.commons.DomainResult
import com.pedrosequeira.showcase.domain.movies.Movie
import com.pedrosequeira.showcase.domain.movies.MovieDetails
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class MoviesRepositoryImpl @Inject constructor(
    private val moviePagingSource: MoviePagingSource,
    private val moviesDataStores: MoviesDataStores,
    private val movieMapper: DataMovieMapper,
    private val errorMapper: ErrorMapper
) : MoviesRepository {

    override fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { moviePagingSource }
        ).flow
    }

    override suspend fun getMovieDetails(id: Int): DomainResult<MovieDetails> {
        return moviesDataStores.remote.getMovieDetails(id).mapEither(
            success = movieMapper::mapToDomainMovieDetails,
            failure = errorMapper::mapToDomainError
        )
    }

    companion object {
        internal const val PAGE_SIZE = 20
    }
}
