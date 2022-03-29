package com.pedrosequeira.domain.usecases

import com.pedrosequeira.domain.entities.IOResult
import com.pedrosequeira.domain.entities.Pagination

interface GetTopRatedMoviesUseCase {
    suspend fun getTopRatedMovies(): IOResult<Pagination>
}
