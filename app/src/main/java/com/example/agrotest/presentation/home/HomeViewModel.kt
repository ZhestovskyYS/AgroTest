package com.example.agrotest.presentation.home

import androidx.lifecycle.ViewModel
import com.example.agrotest.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateToWeightsScreen() {
        router.navigateTo(Screens.weights())
    }

    fun navigateToReportsScreen() {
        router.navigateTo(Screens.reports())
    }

    fun navigateToSettingsScreen() {
        router.navigateTo(Screens.settings())
    }
}