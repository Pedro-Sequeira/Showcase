package com.pedrosequeira.showcase.mdb.api

import com.pedrosequeira.domain.entities.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int
    ): IOResult<ApiPagination>
}
