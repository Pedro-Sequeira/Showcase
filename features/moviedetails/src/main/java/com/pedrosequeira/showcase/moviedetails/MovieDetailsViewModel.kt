package com.pedrosequeira.showcase.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosequeira.showcase.domain.usecases.GetMovieDetailsUseCase
import com.pedrosequeira.showcase.moviedetails.MovieDetailsState.Data
import com.pedrosequeira.showcase.moviedetails.MovieDetailsState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<MovieDetailsState> = MutableStateFlow(Loading)
    val uiState: StateFlow<MovieDetailsState> = _uiState

    fun getMovieDetails(id: Int) {
        viewModelScope.launch {
            _uiState.value = Loading
            val response = getMovieDetailsUseCase.invoke(id)
            _uiState.value = Data(response)
        }
    }
}
