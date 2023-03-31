package io.neomsoft.ciceronconposenavigation.navigation.ciceron

import io.neomsoft.ciceronconposenavigation.navigation.compose.Destination

object Screens {

    val main = ComposeScreen(Destination.Screen.Main.route)

    val second = ComposeScreen(Destination.Screen.Second.route)

    fun third(id: String) = ComposeScreen(Destination.Screen.Third.createRoute(id))
}