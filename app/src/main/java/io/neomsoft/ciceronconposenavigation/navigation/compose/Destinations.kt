package io.neomsoft.ciceronconposenavigation.navigation.compose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.terrakok.cicerone.Router
import io.neomsoft.ciceronconposenavigation.ui.screens.main.MainScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.onboarding.OnboardingScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.second.SecondScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.third.ThirdScreen

@SuppressLint("ComposableNaming")
sealed class Destination(
    protected val _route: String,
    private val screenCreator: @Composable (router: Router) -> Unit
) {

    open val route = _route
    open val arguments = emptyList<NamedNavArgument>()

    @Composable
    open fun screen(
        router: Router,
        navBackStackEntry: NavBackStackEntry
    ) = screenCreator(router = router)

    abstract class Screen {

        object Onboarding : Destination( "onboarding", { OnboardingScreen(it) })

        object Main : Destination("main", { MainScreen() })

        object Second : Destination("second", { SecondScreen(it) })

        object Third : Destination("third", {}) {
            private const val argId = "id"

            override val route = "$_route/{$argId}"
            override val arguments = listOf(navArgument(argId) { type = NavType.StringType })

            @Composable
            override fun screen(
                router: Router,
                navBackStackEntry: NavBackStackEntry
            ) {
                ThirdScreen(
                    router = router,
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