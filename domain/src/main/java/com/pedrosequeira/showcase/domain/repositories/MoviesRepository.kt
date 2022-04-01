package com.pedrosequeira.showcase.domain.repositories

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getTopRatedMovies(): Flow<PagingData<Movie>>
}
