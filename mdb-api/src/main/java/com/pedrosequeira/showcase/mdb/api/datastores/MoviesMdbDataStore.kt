package com.pedrosequeira.showcase.mdb.api.datastores

import com.pedrosequeira.showcase.data.datastores.MoviesRemoteDataStore
import com.pedrosequeira.showcase.data.entities.commons.DataPagination
import com.pedrosequeira.showcase.data.entities.movies.DataMovieDetails
import com.pedrosequeira.showcase.mdb.api.mappers.toDataMovieDetails
import com.pedrosequeira.showcase.mdb.api.service.MoviesEndpoint
import com.pedrosequeira.showcase.mdb.api.mappers.toDataPagination
import javax.inject.Inject

internal class MoviesMdbDataStore @Inject constructor(
    private val moviesEndpoint: MoviesEndpoint
) : MoviesRemoteDataStore {

    override suspend fun getTopRatedMovies(page: Int): DataPagination {
        return moviesEndpoint.getTopRatedMovies(page).toDataPagination()
    }

    override suspend fun getMovieDetails(id: Int): DataMovieDetails {
        return moviesEndpoint.getMovieDetails(id).toDataMovieDetails()
    }
}
