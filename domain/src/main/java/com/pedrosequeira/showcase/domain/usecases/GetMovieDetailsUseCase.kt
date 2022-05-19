package com.pedrosequeira.showcase.domain.usecases

import com.pedrosequeira.showcase.domain.entities.movies.MovieDetails
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(id: Int): MovieDetails {
        return repository.getMovieDetails(id)
    }
}
