package com.pedrosequeira.showcase.domain.usecases

import androidx.paging.PagingData
import com.pedrosequeira.domain.entities.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    suspend fun getTopRatedMovies(): Flow<PagingData<Movie>>
}
