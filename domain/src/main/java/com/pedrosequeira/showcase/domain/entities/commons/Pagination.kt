package com.pedrosequeira.showcase.domain.entities.commons

import com.pedrosequeira.showcase.domain.entities.movies.Movie

data class Pagination(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
