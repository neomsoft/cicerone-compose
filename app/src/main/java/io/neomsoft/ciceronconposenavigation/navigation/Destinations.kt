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
import io.neomsoft.ciceronecompose.Destination
import io.neomsoft.ciceronecompose.RouteInfo

@SuppressLint("ComposableNaming")
object Destinations {

    object Onboarding : Destination() {

        override val routeInfo = RouteInfo.withoutArguments("onboarding")

        @Composable
        override fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
            OnboardingScreen(router)
        }
    }

    object Main : Destination() {

        override val routeInfo = RouteInfo.withoutArguments("main")

        val screen = routeInfo.screen()

        @Composable
        override fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
            MainScreen()
        }
    }


    object Second : Destination() {

        override val routeInfo = RouteInfo.withoutArguments("second")

        val screen = routeInfo.screen()

        @Composable
        override fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
            SecondScreen(router)
        }
    }

    object Third : Destination() {

        private const val ARG_ID = "id"
        private const val THIRD_ROUTE = "third"

        override val routeInfo =
            RouteInfo(
                pattern = "$THIRD_ROUTE/{$ARG_ID}",
                arguments = listOf(navArgument(ARG_ID) { type = NavType.StringType })
            )

        fun screen(id: String) = routeInfo.screen(argumentNameValues = mapOf(ARG_ID to id))

        @Composable
        override fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
            ThirdScreen(
                router = router,
                id = navBackStackEntry.arguments!!.getString(ARG_ID)!!
            )
        }
    }

    fun values(): List<Destination> {
        return listOf(
            Onboarding,
            Main,
            Second,
            Third
        )
    }
}
