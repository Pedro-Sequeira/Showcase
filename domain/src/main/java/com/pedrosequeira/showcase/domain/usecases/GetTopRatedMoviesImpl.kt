package com.pedrosequeira.showcase.domain.usecases

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.entities.Movie
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class GetTopRatedMoviesImpl @Inject constructor(
    private val repository: MoviesRepository
) : GetTopRatedMovies {

    override fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return repository.getTopRatedMovies()
    }
}
