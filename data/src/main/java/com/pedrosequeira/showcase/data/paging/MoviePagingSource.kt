package com.pedrosequeira.showcase.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pedrosequeira.showcase.data.datastores.MoviesDataStores
import com.pedrosequeira.showcase.data.mappers.toMovie
import com.pedrosequeira.showcase.data.repositories.MoviesRepositoryImpl.Companion.PAGE_SIZE
import com.pedrosequeira.showcase.domain.movies.Movie
import java.io.IOException
import java.net.HttpRetryException
import javax.inject.Inject

internal class MoviePagingSource @Inject constructor(
    private val moviesDataStores: MoviesDataStores
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: FIRST_PAGE_INDEX

            val response = moviesDataStores.remote.getTopRatedMovies(pageNumber)

            val previousKey = if (pageNumber > FIRST_PAGE_INDEX) pageNumber - 1 else null

            val nextKey = with(response) {
                if (page < totalPages) pageNumber + 1 else null
            }

            fun calculateItemsAfter(): Int {
                val remainingItems = response.totalResults - (PAGE_SIZE * pageNumber)
                return when {
                    remainingItems < 0 -> 0
                    else -> remainingItems % (response.totalPages * PAGE_SIZE)
                }
            }

            LoadResult.Page(
                data = response.results.map { it.toMovie() },
                prevKey = previousKey,
                nextKey = nextKey,
                itemsAfter = if (response.totalPages == 0) 0 else calculateItemsAfter()
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpRetryException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}
