package com.pedrosequeira.showcase.mdb.api.datastores

import com.github.michaelbull.result.fold
import com.pedrosequeira.showcase.data.datastores.MoviesRemoteDataStore
import com.pedrosequeira.showcase.data.entities.commons.DataPagination
import com.pedrosequeira.showcase.data.entities.movies.DataMovieDetails
import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.Error
import com.pedrosequeira.showcase.mdb.api.entities.httpErrorMessage
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovieDetails
import com.pedrosequeira.showcase.mdb.api.mappers.toDataMovieDetails
import com.pedrosequeira.showcase.mdb.api.mappers.toDataPagination
import com.pedrosequeira.showcase.mdb.api.service.MoviesEndpoint
import javax.inject.Inject

internal class MoviesMdbDataStore @Inject constructor(
    private val moviesEndpoint: MoviesEndpoint
) : MoviesRemoteDataStore {

    override suspend fun getTopRatedMovies(page: Int): DataPagination {
        return moviesEndpoint.getTopRatedMovies(page).toDataPagination()
    }

    override suspend fun getMovieDetails(id: Int): IOResult<DataMovieDetails> {
        return moviesEndpoint.getMovieDetails(id).fold(
            success = onSuccess(),
            failure = onFailure()
        )
    }

    private fun onSuccess(): (ApiMovieDetails) -> IOResult<DataMovieDetails> =
        { IOResult.Success(it.toDataMovieDetails()) }

    private fun onFailure(): (Error) -> IOResult<DataMovieDetails> =
        { IOResult.Error.NetworkError(
            statusMessage = it.httpErrorMessage
        ) }
}
