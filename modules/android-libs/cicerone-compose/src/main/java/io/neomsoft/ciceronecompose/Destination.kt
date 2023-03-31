package io.neomsoft.ciceronecompose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.github.terrakok.cicerone.Router

@SuppressLint("ComposableNaming")
abstract class Destination(
    protected val route: String,
    internal val routeWithArguments: String = route,
    internal val arguments: List<NamedNavArgument> = emptyList()
) {
    protected open fun toScreen(): ComposeScreen {
        return ComposeScreen(routeWithArguments)
    }

    @Composable
    internal fun drawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
        createScreen(router = router, navBackStackEntry = navBackStackEntry)
    }

    @Composable
    protected abstract fun createScreen(router: Router, navBackStackEntry: NavBackStackEntry)
}