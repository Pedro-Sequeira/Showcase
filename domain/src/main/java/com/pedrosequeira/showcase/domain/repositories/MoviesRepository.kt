package com.pedrosequeira.showcase.domain.repositories

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.commons.DomainResult
import com.pedrosequeira.showcase.domain.movies.Movie
import com.pedrosequeira.showcase.domain.movies.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getTopRatedMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(id: Int): DomainResult<MovieDetails>
}
