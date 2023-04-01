package io.neomsoft.ciceronecompose

import androidx.navigation.NamedNavArgument
import com.github.terrakok.cicerone.Screen

data class RouteInfo(
    internal val pattern: String,
    internal val arguments: List<NamedNavArgument>
) {
    fun screen(argumentNameValues: Map<String, String> = emptyMap()): Screen {
        return ComposeScreen(route = route(argumentNameValues))
    }

    private fun route(argumentNameValues: Map<String, String> = emptyMap()): String {
        checkArgumentsCount(argumentNameValues.size)
        var route = pattern
        argumentNameValues.forEach { (name, value) ->
            checkArgumentName(name)
            route = route.replace("{$name}", value)
        }
        return route
    }

    private fun checkArgumentName(argumentName: String) {
        if (arguments.none { it.name == argumentName }) {
            throw IllegalArgumentException("Argument $argumentName is not registered")
        }
    }

    private fun checkArgumentsCount(receivedValuesCount: Int) {
        if (arguments.size != receivedValuesCount) {
            throw IllegalArgumentException(
                "Some values is not provided or missed. " +
                        "Arguments count: ${arguments.size}, received values count: $receivedValuesCount"
            )
        }
    }

    companion object {
        fun withoutArguments(name: String): RouteInfo {
            return RouteInfo(
                pattern = name,
                arguments = emptyList()
            )
        }
    }
}
