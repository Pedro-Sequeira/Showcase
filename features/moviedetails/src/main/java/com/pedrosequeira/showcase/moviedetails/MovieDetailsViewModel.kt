package com.pedrosequeira.showcase.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosequeira.showcase.core.dispatcher.DispatcherProvider
import com.pedrosequeira.showcase.core.extensions.onError
import com.pedrosequeira.showcase.core.extensions.resultOrError
import com.pedrosequeira.showcase.domain.usecases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

private const val MOVIE_ID_ARG = "movieId"

@HiltViewModel
internal class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val reducer: MovieDetailsReducer,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private var getMovieDetailsJob: Job? = null

    var uiState = MutableStateFlow(MovieDetailsState())
        private set

    private val currentUiState: MovieDetailsState
        get() = uiState.value

    private val movieId = checkNotNull(savedStateHandle.get<Int>(MOVIE_ID_ARG))

    init {
        getMovieDetailsJob = viewModelScope.launch {
            getMovieDetailsUseCase.invoke(movieId)
                .resultOrError()
                .map {
                    reducer.mapToSuccessState(currentUiState, it)
                }
                .flowOn(dispatcherProvider.computation)
                .onError {
                    emit(reducer.mapToErrorState(currentUiState, it))
                }
                .onStart {
                    emit(reducer.changeLoadingStateTo(currentUiState, true))
                }
                .onCompletion {
                    emit(reducer.changeLoadingStateTo(currentUiState, false))
                }
                .collect { uiState.value = it }
        }
    }
}
