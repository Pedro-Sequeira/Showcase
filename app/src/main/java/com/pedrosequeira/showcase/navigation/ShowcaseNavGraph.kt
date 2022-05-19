package com.pedrosequeira.showcase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pedrosequeira.showcase.dashboard.DashboardScreen
import com.pedrosequeira.showcase.moviedetails.MovieDetails
import com.pedrosequeira.showcase.navigation.ShowcaseDestinationsArgs.MOVIE_ID_ARG

@Composable
fun ShowcaseNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ShowcaseDestinations.DASHBOARD_ROUTE,
    navActions: ShowcaseNavigationActions = remember(navController) {
        ShowcaseNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ShowcaseDestinations.DASHBOARD_ROUTE) {
            DashboardScreen(
                onMovieClick = { id ->
                    navActions.navigateToMovieDetails(id)
                }
            )
        }
        composable(
            route = ShowcaseDestinations.DETAILS_ROUTE,
            arguments = listOf(
                navArgument(MOVIE_ID_ARG) { type = NavType.IntType }
            )
        ) { entry ->
            MovieDetails(movieId = entry.arguments?.getInt(MOVIE_ID_ARG))
        }
    }
}
