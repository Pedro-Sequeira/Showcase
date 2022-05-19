package com.pedrosequeira.showcase.mdb.api.service

import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovieDetails
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination
import javax.inject.Inject

internal class MoviesEndpointImpl @Inject constructor(
    private val service: MoviesService
) : MoviesEndpoint {

    override suspend fun getTopRatedMovies(page: Int): ApiPagination {
        return service.getTopRated(page)
    }

    override suspend fun getMovieDetails(id: Int): ApiMovieDetails {
        return service.getMovieDetails(id)
    }
}
