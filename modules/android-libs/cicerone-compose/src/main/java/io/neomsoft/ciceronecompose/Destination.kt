package io.neomsoft.ciceronecompose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.github.terrakok.cicerone.Router

@SuppressLint("ComposableNaming")
abstract class Destination {

    abstract val routeInfo: RouteInfo

    @Composable
    internal fun drawScreen(router: Router, navBackStackEntry: NavBackStackEntry) {
        onDrawScreen(router = router, navBackStackEntry = navBackStackEntry)
    }

    @Composable
    protected abstract fun onDrawScreen(router: Router, navBackStackEntry: NavBackStackEntry)
}
