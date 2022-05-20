package com.example.agrotest.navigation

import com.example.agrotest.presentation.home.HomeFragment
import com.example.agrotest.presentation.reports.ReportsFragment
import com.example.agrotest.presentation.settings.SettingsFragment
import com.example.agrotest.presentation.weights.WeightsFragment
import com.example.agrotest.presentation.weightshistory.WeightsHistoryFragment
import com.example.entity.WeightsHistory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun home() = FragmentScreen { HomeFragment() }

    fun weights() = FragmentScreen { WeightsFragment() }

    fun reports() = FragmentScreen { ReportsFragment() }

    fun settings() = FragmentScreen { SettingsFragment() }

    fun weightsHistory(id: String) = FragmentScreen {
        WeightsHistoryFragment.newInstance(id)
    }
}