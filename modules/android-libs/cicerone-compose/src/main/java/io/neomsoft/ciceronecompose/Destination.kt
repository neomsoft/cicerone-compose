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

    @Composable
    protected abstract fun screen(router: Router)

    protected open fun toScreen(): ComposeScreen {
        return ComposeScreen(routeWithArguments)
    }

    @Composable
    open fun screen(
        router: Router,
        navBackStackEntry: NavBackStackEntry
    ) = screen(router)
}