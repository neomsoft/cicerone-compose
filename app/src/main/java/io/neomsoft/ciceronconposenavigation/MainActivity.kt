package io.neomsoft.ciceronconposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import io.neomsoft.ciceronconposenavigation.navigation.Destination
import io.neomsoft.ciceronconposenavigation.navigation.NavigationHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavigationHost(
                navController = navController,
                startDestination = Destination.Screen.Onboarding,
                modifier = Modifier
            )
        }
    }
}