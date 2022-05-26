package com.pedrosequeira.showcase.mdb.api.service

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovieDetails
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination

internal interface MoviesEndpoint {

    suspend fun getTopRatedMovies(page: Int): ApiPagination

    suspend fun getMovieDetails(id: Int): IOResult<ApiMovieDetails>
}
