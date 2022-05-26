package com.pedrosequeira.showcase.data.datastores

import com.pedrosequeira.showcase.data.entities.commons.DataPagination
import com.pedrosequeira.showcase.data.entities.movies.DataMovieDetails
import com.pedrosequeira.showcase.domain.entities.commons.IOResult

interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): DataPagination

    suspend fun getMovieDetails(id: Int): IOResult<DataMovieDetails>
}
