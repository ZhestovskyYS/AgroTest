package com.example.agrotest.navigation

import com.example.agrotest.presentation.home.HomeFragment
import com.example.agrotest.presentation.reports.ReportsFragment
import com.example.agrotest.presentation.weights.WeightsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun home() = FragmentScreen { HomeFragment() }

    fun weights() = FragmentScreen { WeightsFragment() }

    fun reports() = FragmentScreen { ReportsFragment() }
}