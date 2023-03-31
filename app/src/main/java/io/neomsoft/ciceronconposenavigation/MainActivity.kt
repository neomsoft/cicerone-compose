package io.neomsoft.ciceronconposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import io.neomsoft.ciceronconposenavigation.navigation.Destinations
import io.neomsoft.ciceronecompose.NavigationHost
import io.neomsoft.ciceronecompose.NavigatorImpl
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder

    private var navigator: NavigatorImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController: NavHostController = rememberNavController()
            navigator = NavigatorImpl(navController = navController)

            if (lifecycle.currentState == Lifecycle.State.RESUMED) {
                navigatorHolder.setNavigator(navigator!!)
            }

            NavigationHost(
                router = router,
                navController = navController,
                startDestination = Destinations.Onboarding,
                destinations = Destinations.values(),
                modifier = Modifier
            )
        }
    }

    override fun onResume() {
        super.onResume()

        if (navigator != null) {
            navigatorHolder.setNavigator(navigator!!)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}