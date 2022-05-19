package com.pedrosequeira.showcase.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pedrosequeira.showcase.data.datastores.MoviesDataStores
import com.pedrosequeira.showcase.data.mappers.toMovieDetails
import com.pedrosequeira.showcase.data.paging.MoviePagingSource
import com.pedrosequeira.showcase.domain.entities.movies.Movie
import com.pedrosequeira.showcase.domain.entities.movies.MovieDetails
import com.pedrosequeira.showcase.domain.repositories.MoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MoviesRepositoryImpl @Inject constructor(
    private val moviePagingSource: MoviePagingSource,
    private val moviesDataStores: MoviesDataStores
) : MoviesRepository {

    override fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { moviePagingSource }
        ).flow
    }

    override suspend fun getMovieDetails(id: Int): MovieDetails {
        return moviesDataStores.remote.getMovieDetails(id).toMovieDetails()
    }

    companion object {
        internal const val PAGE_SIZE = 20
    }
}
