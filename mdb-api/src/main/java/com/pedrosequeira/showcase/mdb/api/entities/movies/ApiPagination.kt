package com.pedrosequeira.showcase.mdb.api.entities.movies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiPagination(

    @SerialName("page")
    val page: Int? = null,

    @SerialName("results")
    val results: List<ApiMovie>? = null,

    @SerialName("total_pages")
    val totalPages: Int? = null,

    @SerialName("total_results")
    val totalResults: Int? = null
)
