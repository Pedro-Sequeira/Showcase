package com.pedrosequeira.showcase.dashboard

import androidx.lifecycle.ViewModel
import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
    getTopRatedMovies: GetTopRatedMovies
) : ViewModel() {

    val movies = getTopRatedMovies.getTopRatedMovies()
}
