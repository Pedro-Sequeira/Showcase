package com.pedrosequeira.showcase.mdb.api.entities.movies

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiTopRatedMovies(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "results")
    val movies: List<ApiMovie>? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null
)
