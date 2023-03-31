package io.neomsoft.ciceronconposenavigation.ui.screens.third

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
import io.neomsoft.ciceronconposenavigation.ui.theme.CiceronConposeNavigationTheme

@Composable
fun ThirdScreen(
    router: Router,
    id: String
) {
    ThirdScreen(
        onClick = { router.exit() },
        id = id,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ThirdScreen(
    onClick: () -> Unit,
    id: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Third screen with id = $id")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick
            ) {
                Text(text = "Back")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ThirdScreenPreview() {
    CiceronConposeNavigationTheme {
        ThirdScreen(
            onClick = {},
            id = "test id",
        )
    }
}