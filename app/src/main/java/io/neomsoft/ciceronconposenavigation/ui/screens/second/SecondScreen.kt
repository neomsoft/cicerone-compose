package io.neomsoft.ciceronconposenavigation.ui.screens.second

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.neomsoft.ciceronconposenavigation.navigation.Destination
import io.neomsoft.ciceronconposenavigation.navigation.navigateSingleTopTo
import io.neomsoft.ciceronconposenavigation.ui.theme.CiceronConposeNavigationTheme

@Composable
fun SecondScreen(
    navController: NavHostController
) = SecondScreen(
    onClick = {
        val route = Destination.Screen.Third.createRoute("testid")
        navController.navigateSingleTopTo(route)
    },
    modifier = Modifier.fillMaxSize()
)

@Composable
fun SecondScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Second screen")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick
            ) {
                Text(text = "Go to third screen with arguments")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecondScreenPreview() {
    CiceronConposeNavigationTheme {
        SecondScreen(
            onClick = {}
        )
    }
}