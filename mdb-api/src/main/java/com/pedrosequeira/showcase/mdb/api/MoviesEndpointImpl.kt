package com.pedrosequeira.showcase.mdb.api

import com.pedrosequeira.showcase.mdb.api.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiTopRatedMovies
import javax.inject.Inject

internal class MoviesEndpointImpl @Inject constructor(
    private val service: MoviesService
) : MoviesEndpoint {

    override suspend fun getTopRatedMovies(page: Int): IOResult<ApiTopRatedMovies> {
        return service.getTopRated(page)
    }
}
