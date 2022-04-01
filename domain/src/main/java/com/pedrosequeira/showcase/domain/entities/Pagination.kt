package com.pedrosequeira.showcase.domain.entities

data class Pagination(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
