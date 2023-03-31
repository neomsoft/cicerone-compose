package io.neomsoft.ciceronconposenavigation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import io.neomsoft.ciceronconposenavigation.ui.screens.main.MainScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.onboarding.OnboardingScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.second.SecondScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.third.ThirdScreen

@SuppressLint("ComposableNaming")
sealed class Destination(
    protected val _route: String,
    private val screenCreator: @Composable (navController: NavHostController) -> Unit
) {

    open val route = _route
    open val arguments = emptyList<NamedNavArgument>()

    @Composable
    open fun screen(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry
    ) = screenCreator(navController = navController)

    abstract class Screen {

        object Onboarding : Destination( "onboarding", { OnboardingScreen(it) })

        object Main : Destination("main", { MainScreen(it) })

        object Second : Destination("second", { SecondScreen(it) })

        object Third : Destination("third", {}) {
            private const val argId = "id"

            override val route = "$_route/{$argId}"
            override val arguments = listOf(navArgument(argId) { type = NavType.StringType })

            @Composable
            override fun screen(
                navController: NavHostController,
                navBackStackEntry: NavBackStackEntry
            ) {
                ThirdScreen(
                    navController = navController,
                    id = navBackStackEntry.arguments!!.getString(argId)!!
                )
            }

            fun createRoute(id: String) = "$_route/$id"
        }
    }


    companion object {

        fun values(): List<Destination> = listOf(
            Screen.Onboarding,
            Screen.Main,
            Screen.Second,
            Screen.Third,
        )
    }
}