package com.pedrosequeira.showcase.mdb.api

import com.pedrosequeira.domain.entities.IOResult
import com.pedrosequeira.domain.entities.map
import com.pedrosequeira.showcase.data.MoviesRemoteDataStore
import com.pedrosequeira.showcase.data.entities.DataPagination
import com.pedrosequeira.showcase.mdb.api.mappers.mapToDataPagination
import javax.inject.Inject

internal class MoviesMdbDataStore @Inject constructor(
    private val moviesEndpoint: MoviesEndpoint
) : MoviesRemoteDataStore {

    override suspend fun getTopRatedMovies(): IOResult<DataPagination> {
        return moviesEndpoint.getTopRatedMovies(1).map {
            it.mapToDataPagination()
        }
    }
}
