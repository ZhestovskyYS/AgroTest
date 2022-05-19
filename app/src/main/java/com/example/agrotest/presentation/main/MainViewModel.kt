package com.example.agrotest.presentation.main

import androidx.lifecycle.ViewModel
import com.example.agrotest.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateToStartScreen() {
        router.newRootChain(Screens.home())
    }
}