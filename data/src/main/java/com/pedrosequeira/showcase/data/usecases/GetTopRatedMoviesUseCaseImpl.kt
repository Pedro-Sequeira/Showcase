package com.pedrosequeira.showcase.data.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pedrosequeira.showcase.data.paging.MoviePagingSource
import com.pedrosequeira.showcase.domain.entities.Movie
import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMoviesUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class GetTopRatedMoviesUseCaseImpl @Inject constructor(
    private val moviePagingSource: MoviePagingSource
) : GetTopRatedMoviesUseCase {

    override fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { moviePagingSource }
        ).flow
    }
}
