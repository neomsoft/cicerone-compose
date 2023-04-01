package io.neomsoft.ciceronecompose

import com.github.terrakok.cicerone.Screen

data class ComposeScreen(val route: String) : Screen {
    override val screenKey = route
}
