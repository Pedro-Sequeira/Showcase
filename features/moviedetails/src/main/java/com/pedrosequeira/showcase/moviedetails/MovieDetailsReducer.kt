package com.pedrosequeira.showcase.moviedetails

import com.pedrosequeira.showcase.core.ErrorMapper
import com.pedrosequeira.showcase.domain.movies.MovieDetails
import javax.inject.Inject

internal class MovieDetailsReducer @Inject constructor(
    private val errorMapper: ErrorMapper
) {
    fun mapToSuccessState(state: MovieDetailsState, details: MovieDetails?) =
        state.copy(isLoading = false, movieDetails = details)

    fun changeLoadingStateTo(state: MovieDetailsState, isLoading: Boolean) =
        state.copy(isLoading = isLoading)

    fun mapToErrorState(state: MovieDetailsState, it: Throwable) =
        state.copy(isLoading = false, errorMessage = errorMapper.mapToMessage(it))
}
