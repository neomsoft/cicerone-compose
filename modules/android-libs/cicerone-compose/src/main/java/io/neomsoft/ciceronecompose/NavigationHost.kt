package io.neomsoft.ciceronecompose

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
    destinations: List<Destination>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.routeWithArguments,
        modifier = modifier
    ) {
        destinations.forEach { destination ->

            composable(
                route = destination.routeWithArguments,
                arguments = destination.arguments,
            ) {
                destination.drawScreen(router = router, navBackStackEntry = it)
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
