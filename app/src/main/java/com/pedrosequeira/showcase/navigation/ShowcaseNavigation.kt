package com.pedrosequeira.showcase.navigation

import androidx.navigation.NavHostController
import com.pedrosequeira.showcase.navigation.ShowcaseDestinationsArgs.MOVIE_ID_ARG
import com.pedrosequeira.showcase.navigation.ShowcaseScreens.DASHBOARD_SCREEN
import com.pedrosequeira.showcase.navigation.ShowcaseScreens.DETAILS_SCREEN

internal object ShowcaseScreens {
    const val DASHBOARD_SCREEN = "dashboard"
    const val DETAILS_SCREEN = "details"
}

internal object ShowcaseDestinationsArgs {
    const val MOVIE_ID_ARG = "movieId"
}

internal object ShowcaseDestinations {
    const val DASHBOARD_ROUTE = "$DASHBOARD_SCREEN"
    const val DETAILS_ROUTE = "$DETAILS_SCREEN/{$MOVIE_ID_ARG}"
}

class ShowcaseNavigationActions(private val navController: NavHostController) {

    fun navigateToMovieDetails(movieId: Int) {
        navController.navigate(
            route = "$DETAILS_SCREEN/$movieId"
        ) {
            restoreState = true
        }
    }
}
