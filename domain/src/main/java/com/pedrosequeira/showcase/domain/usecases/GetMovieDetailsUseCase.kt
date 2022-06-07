package com.pedrosequeira.showcase.domain.usecases

import com.pedrosequeira.showcase.domain.commons.DomainResult
import com.pedrosequeira.showcase.domain.movies.MovieDetails
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(id: Int): Flow<DomainResult<MovieDetails>> {
        return flow {
            emit(repository.getMovieDetails(id))
        }
    }
}
