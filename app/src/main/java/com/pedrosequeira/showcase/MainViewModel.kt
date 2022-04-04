package com.pedrosequeira.showcase

import androidx.lifecycle.ViewModel
import com.pedrosequeira.showcase.core.connectivity.NetworkStatusTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val networkStatusTracker: NetworkStatusTracker
) : ViewModel()
