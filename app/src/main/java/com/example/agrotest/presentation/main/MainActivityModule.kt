package com.example.agrotest.presentation.main

import androidx.lifecycle.ViewModel
import com.example.agrotest.presentation.home.HomeFragment
import com.example.agrotest.presentation.home.HomeModule
import com.example.agrotest.presentation.reports.ReportsFragment
import com.example.agrotest.presentation.reports.ReportsModule
import com.example.agrotest.presentation.settings.SettingsFragment
import com.example.agrotest.presentation.settings.SettingsModule
import com.example.agrotest.presentation.weights.WeightsFragment
import com.example.agrotest.presentation.weights.WeightsModule
import com.example.agrotest.presentation.weights.WeightsViewModel
import com.example.agrotest.presentation.weightshistory.WeightsHistoryFragment
import com.example.agrotest.presentation.weightshistory.WeightsHistoryModule
import com.example.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector(modules = [HomeModule::class])
    fun contributeToHomeScreen(): HomeFragment

    @ContributesAndroidInjector(modules = [WeightsModule::class])
    fun contributeToWeightsScreen(): WeightsFragment

    @ContributesAndroidInjector(modules = [ReportsModule::class])
    fun contributeToReportsScreen(): ReportsFragment

    @ContributesAndroidInjector(modules = [SettingsModule::class])
    fun contributeToSettingsScreen(): SettingsFragment

    @ContributesAndroidInjector(modules = [WeightsHistoryModule::class])
    fun contributeToWeightsHistoryScreen(): WeightsHistoryFragment
}