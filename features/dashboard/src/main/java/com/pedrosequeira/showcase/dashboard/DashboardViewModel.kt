package com.pedrosequeira.showcase.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosequeira.domain.usecases.GetTopRatedMoviesUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class DashboardViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    internal fun getTopRatedMovies() {
        viewModelScope.launch {
            getTopRatedMoviesUseCase.getTopRatedMovies()
        }
    }
}
