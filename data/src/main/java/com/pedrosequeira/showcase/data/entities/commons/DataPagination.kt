package com.pedrosequeira.showcase.data.entities.commons

import com.pedrosequeira.showcase.data.entities.movies.DataMovie

data class DataPagination(
    val page: Int,
    val results: List<DataMovie>,
    val totalPages: Int,
    val totalResults: Int
)
