package com.example.agrotest.presentation.reports

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ReportsViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    fun navigateBack() {
        router.exit()
    }
}