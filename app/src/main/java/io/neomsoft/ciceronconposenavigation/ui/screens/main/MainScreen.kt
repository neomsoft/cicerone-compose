package io.neomsoft.ciceronconposenavigation.ui.screens.main

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
import androidx.hilt.navigation.compose.hiltViewModel
import io.neomsoft.ciceronconposenavigation.ui.theme.CiceronConposeNavigationTheme

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = hiltViewModel()

    MainScreen(
        onClick = { viewModel.onClick() },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun MainScreen(
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
            Text(text = "Main screen")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick
            ) {
                Text(text = "Go to second screen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    CiceronConposeNavigationTheme {
        MainScreen(
            onClick = {}
        )
    }
}