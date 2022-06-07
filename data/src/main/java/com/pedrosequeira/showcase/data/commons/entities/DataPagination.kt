package com.pedrosequeira.showcase.data.commons.entities

import com.pedrosequeira.showcase.data.movies.DataMovie

data class DataPagination(
    val page: Int,
    val results: List<DataMovie>,
    val totalPages: Int,
    val totalResults: Int
)
