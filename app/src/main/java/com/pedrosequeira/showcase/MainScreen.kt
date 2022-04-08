package com.pedrosequeira.showcase

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrosequeira.showcase.commons.ui.ScreenWithDialog
import com.pedrosequeira.showcase.core.connectivity.NetworkStatus

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    screen: @Composable () -> Unit
) {
    val isConnected by mainViewModel.networkStatusTracker.networkStatus.collectAsState(
        initial = NetworkStatus.Available
    )

    ScreenWithDialog(
        shouldShowDialog = isConnected == NetworkStatus.Unavailable,
        text = "You have no internet connection",
        screen = screen
    )
}
