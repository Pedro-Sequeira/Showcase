package com.pedrosequeira.showcase.domain.usecases

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.entities.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {

    fun getTopRatedMovies(): Flow<PagingData<Movie>>
}
