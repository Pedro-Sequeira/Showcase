package com.pedrosequeira.showcase.domain.commons.entities

import com.pedrosequeira.showcase.domain.movies.Movie

data class Pagination(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)
