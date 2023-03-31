package io.neomsoft.ciceronconposenavigation.ui.screens.main

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import io.neomsoft.ciceronconposenavigation.navigation.ciceron.Screens
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun onClick() {
        router.navigateTo(Screens.second)
    }
}