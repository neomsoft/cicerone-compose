package io.neomsoft.ciceronconposenavigation.ui.screens.onboarding

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
import com.github.terrakok.cicerone.Router
import io.neomsoft.ciceronconposenavigation.navigation.ciceron.Screens
import io.neomsoft.ciceronconposenavigation.ui.theme.CiceronConposeNavigationTheme

@Composable
fun OnboardingScreen(
    router: Router
) = OnboardingScreen(
    onClick = { router.replaceScreen(Screens.main) },
    modifier = Modifier.fillMaxSize()
)

@Composable
fun OnboardingScreen(
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
            Text(text = "Onboarding screen")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick
            ) {
                Text(text = "Go to main screen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    CiceronConposeNavigationTheme {
        OnboardingScreen(
            onClick = {}
        )
    }
}