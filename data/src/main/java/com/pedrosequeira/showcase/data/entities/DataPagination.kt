package com.pedrosequeira.showcase.data.entities

data class DataPagination(
    val page: Int,
    val results: List<DataMovie>,
    val totalPages: Int,
    val totalResults: Int
)
