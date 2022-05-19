package com.example.agrotest.presentation.weights

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class WeightsViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateBack() {
        router.exit()
    }
}