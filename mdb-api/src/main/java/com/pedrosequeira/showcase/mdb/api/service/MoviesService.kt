package com.pedrosequeira.showcase.mdb.api.service

import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiMovieDetails
import com.pedrosequeira.showcase.mdb.api.entities.movies.ApiPagination
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int
    ): ApiPagination

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): ApiMovieDetails
}
