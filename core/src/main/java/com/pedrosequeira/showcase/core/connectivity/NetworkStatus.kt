package com.pedrosequeira.showcase.core.connectivity

sealed class NetworkStatus {
    object Available: NetworkStatus()
    object Unavailable: NetworkStatus()
}
