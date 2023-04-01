package io.neomsoft.ciceronecompose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.github.terrakok.cicerone.Router

@SuppressLint("ComposableNaming")
abstract class Destination(
    internal val route: String,
    internal val arguments: List<NamedNavArgument> = emptyList()
) {

    @Composable
    internal fun drawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
        onDrawScreen(router = router, navBackStackEntry = navBackStackEntry)
    }

    @Composable
    protected abstract fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry)

    protected fun route(argumentNameValues: Map<String, String> = emptyMap()): String {
        checkArguments(argumentNameValues)

        var routeWithValues = route

        argumentNameValues.forEach { (name, value) ->
            routeWithValues = routeWithValues.replace("{$name}", value)
        }

        return routeWithValues
    }

    private fun checkArguments(argumentNameValues: Map<String, String>) {
        if (arguments.size != argumentNameValues.size) {
            throw IllegalArgumentException(
                "Some values is not provided or missed. " +
                        "Arguments count: ${arguments.size}, received values count: ${argumentNameValues.size}"
            )
        }

        argumentNameValues
            .toList()
            .find { pair -> arguments.none { it.name == pair.first } }
            ?.also { throw IllegalArgumentException("Argument $it is not registered") }
    }
}
