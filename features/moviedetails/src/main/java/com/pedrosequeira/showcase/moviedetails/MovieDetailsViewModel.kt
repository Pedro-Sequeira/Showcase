package com.pedrosequeira.showcase.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosequeira.showcase.domain.entities.commons.IOResult.Error
import com.pedrosequeira.showcase.domain.entities.commons.IOResult.Success
import com.pedrosequeira.showcase.domain.usecases.GetMovieDetailsUseCase
import com.pedrosequeira.showcase.moviedetails.MovieDetailsState.Data
import com.pedrosequeira.showcase.moviedetails.MovieDetailsState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val MOVIE_ID_ARG = "movieId"

@HiltViewModel
internal class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<MovieDetailsState> = MutableStateFlow(Loading)
    val uiState: StateFlow<MovieDetailsState> = _uiState

    private val movieId = checkNotNull(savedStateHandle.get<Int>(MOVIE_ID_ARG))

    init {
        viewModelScope.launch {
            _uiState.value = Loading
            when (val response = getMovieDetailsUseCase.invoke(movieId)) {
                is Success -> Data(response.data)
                is Error.NetworkError -> MovieDetailsState.Error(response.statusMessage)
                is Error.NetworkUnavailable -> MovieDetailsState.Error("Network unavailable.")
            }
        }
    }
}
