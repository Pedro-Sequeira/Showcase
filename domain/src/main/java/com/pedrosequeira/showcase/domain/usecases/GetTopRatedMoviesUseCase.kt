package com.pedrosequeira.showcase.domain.usecases

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.entities.Movie
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getTopRatedMovies()
    }
}
