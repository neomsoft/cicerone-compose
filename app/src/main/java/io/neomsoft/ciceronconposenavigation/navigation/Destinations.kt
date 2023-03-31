package io.neomsoft.ciceronconposenavigation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.github.terrakok.cicerone.Router
import io.neomsoft.ciceronconposenavigation.ui.screens.main.MainScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.onboarding.OnboardingScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.second.SecondScreen
import io.neomsoft.ciceronconposenavigation.ui.screens.third.ThirdScreen
import io.neomsoft.ciceronecompose.ComposeScreen
import io.neomsoft.ciceronecompose.Destination

@SuppressLint("ComposableNaming")
object Destinations {

    object Onboarding : Destination(route = "onboarding") {
        @Composable
        override fun screen(router: Router) { OnboardingScreen(router) }

        public override fun toScreen() = super.toScreen()
    }

    object Main : Destination(route = "main") {
        @Composable
        override fun screen(router: Router) { MainScreen() }

        public override fun toScreen() = super.toScreen()
    }

    object Second : Destination(route = "second") {
        @Composable
        override fun screen(router: Router) { SecondScreen(router) }

        public override fun toScreen() = super.toScreen()
    }

    private const val ArgId = "id"
    private const val ThirdRoute = "third"

    object Third : Destination(
        route = ThirdRoute,
        routeWithArguments = "$ThirdRoute/{$ArgId}",
        arguments = listOf(navArgument(ArgId) { type = NavType.StringType })
    ) {
        @Composable
        override fun screen(router: Router) = Unit

        @Composable
        override fun screen(
            router: Router,
            navBackStackEntry: NavBackStackEntry
        ) {
            ThirdScreen(
                router = router,
                id = navBackStackEntry.arguments!!.getString(ArgId)!!
            )
        }

        fun toScreen(id: String): ComposeScreen {
            return ComposeScreen("$route/$id")
        }

    }

    fun values(): List<Destination> = listOf(
        Onboarding,
        Main,
        Second,
        Third,
    )
}