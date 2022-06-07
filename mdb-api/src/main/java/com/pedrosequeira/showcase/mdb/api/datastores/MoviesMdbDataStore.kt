package com.pedrosequeira.showcase.mdb.api.datastores

import com.github.michaelbull.result.mapEither
import com.pedrosequeira.showcase.data.commons.DataResult
import com.pedrosequeira.showcase.data.commons.entities.DataPagination
import com.pedrosequeira.showcase.data.datastores.MoviesRemoteDataStore
import com.pedrosequeira.showcase.data.movies.DataMovieDetails
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import com.pedrosequeira.showcase.mdb.api.mappers.MovieMappers
import com.pedrosequeira.showcase.mdb.api.mappers.toDataPagination
import com.pedrosequeira.showcase.mdb.api.service.MoviesEndpoint
import javax.inject.Inject

internal class MoviesMdbDataStore @Inject constructor(
    private val moviesEndpoint: MoviesEndpoint,
    private val movieMappers: MovieMappers,
    private val errorMapper: ErrorMapper
) : MoviesRemoteDataStore {

    override suspend fun getTopRatedMovies(page: Int): DataPagination {
        return moviesEndpoint.getTopRatedMovies(page).toDataPagination()
    }

    override suspend fun getMovieDetails(id: Int): DataResult<DataMovieDetails> {
        return moviesEndpoint.getMovieDetails(id).mapEither(
            success = movieMappers::toDataMovieDetails,
            failure = errorMapper::mapToDataError
        )
    }
}
