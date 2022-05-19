package com.example.agrotest.navigation

import com.example.agrotest.presentation.home.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun home() = FragmentScreen { HomeFragment() }
}