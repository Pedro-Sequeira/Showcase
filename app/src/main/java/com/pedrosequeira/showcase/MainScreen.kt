package com.pedrosequeira.showcase

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pedrosequeira.showcase.commons.ui.ScreenWithDialog
import com.pedrosequeira.showcase.core.connectivity.NetworkStatus

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    screen: @Composable () -> Unit
) {
    val isConnected by mainViewModel.networkStatusTracker.networkStatus.collectAsStateWithLifecycle(
        initialValue = NetworkStatus.Available
    )

    ScreenWithDialog(
        shouldShowDialog = isConnected == NetworkStatus.Unavailable,
        text = "You have no internet connection",
        screen = screen
    )
}
