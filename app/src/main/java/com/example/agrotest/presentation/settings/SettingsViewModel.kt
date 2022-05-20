package com.example.agrotest.presentation.settings

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateBack() {
        router.exit()
    }
}
