package com.pedrosequeira.showcase.domain.repositories

import androidx.paging.PagingData
import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.domain.entities.movies.Movie
import com.pedrosequeira.showcase.domain.entities.movies.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getTopRatedMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(id: Int): IOResult<MovieDetails>
}
