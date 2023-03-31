package io.neomsoft.ciceronconposenavigation.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.terrakok.cicerone.Router

@Composable
fun NavigationHost(
    router: Router,
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
                destination.screen(router = router, navBackStackEntry = it)
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
