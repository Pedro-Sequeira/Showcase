package com.pedrosequeira.showcase.mdb.api.service

import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination

internal interface MoviesEndpoint {

    suspend fun getTopRatedMovies(page: Int): ApiPagination
}
