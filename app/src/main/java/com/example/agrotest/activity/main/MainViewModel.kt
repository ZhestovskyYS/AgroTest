package com.example.agrotest.activity.main

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateToStartScreen() {
        // TODO: Route to start screen
    }
}