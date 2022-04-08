package com.pedrosequeira.showcase.dashboard

import androidx.lifecycle.ViewModel
import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    val movies = getTopRatedMoviesUseCase.getTopRatedMovies()
}
