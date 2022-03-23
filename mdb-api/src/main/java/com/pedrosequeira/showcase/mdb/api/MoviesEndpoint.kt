package com.pedrosequeira.showcase.mdb.api

import com.pedrosequeira.showcase.mdb.api.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiTopRatedMovies

internal interface MoviesEndpoint {

    suspend fun getTopRatedMovies(page: Int): IOResult<ApiTopRatedMovies>
}
