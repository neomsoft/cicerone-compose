package io.neomsoft.ciceronconposenavigation.navigation.ciceron

import androidx.navigation.NavHostController
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace
import io.neomsoft.ciceronconposenavigation.navigation.compose.navigateSingleTopTo

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
        when(command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
            is Back -> back()
            is BackTo -> TODO()
        }
    }

    private fun forward(command: Forward) {
        navController.navigateSingleTopTo(command.screen.screenKey)
    }

    private fun replace(command: Replace) {
        navController.navigateSingleTopTo(command.screen.screenKey) {
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