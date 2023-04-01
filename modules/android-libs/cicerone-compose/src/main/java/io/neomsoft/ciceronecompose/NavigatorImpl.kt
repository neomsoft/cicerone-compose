package io.neomsoft.ciceronecompose

import androidx.navigation.NavHostController
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace

class NavigatorImpl(
    private val navController: NavHostController
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(command, e)
            }
        }
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward((command.screen as ComposeScreen).route)
            is Replace -> replace((command.screen as ComposeScreen).route)
            is Back -> back()
            is BackTo -> TODO()
        }
    }

    private fun forward(route: String) {
        navController.navigateSingleTopTo(route)
    }

    private fun replace(route: String) {
        navController.navigateSingleTopTo(route) {
            val currentRoute = navController.currentBackStackEntry?.destination?.route

            if (currentRoute != null) {
                popUpTo(currentRoute) { inclusive = true }
            }
        }
    }

    private fun back() {
        navController.navigateUp()
    }

    private fun errorOnApplyCommand(
        command: Command,
        error: RuntimeException
    ) {
        throw error
    }
}
