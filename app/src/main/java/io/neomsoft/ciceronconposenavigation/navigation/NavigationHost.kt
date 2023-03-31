package io.neomsoft.ciceronconposenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        Destination.values().forEach { destination ->
            composable(
                route = destination.route,
                arguments = destination.arguments,
            ) {
                destination.screen(navController = navController, navBackStackEntry = it)
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(
    route: String,
    builder: (NavOptionsBuilder.() -> Unit)? = null
) {
    this.navigate(route = route) {
        launchSingleTop = true

        if (builder != null) builder()
    }
}
