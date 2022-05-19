package com.pedrosequeira.showcase.data.datastores

import com.pedrosequeira.showcase.data.entities.commons.DataPagination
import com.pedrosequeira.showcase.data.entities.movies.DataMovieDetails

interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): DataPagination

    suspend fun getMovieDetails(id: Int): DataMovieDetails
}
