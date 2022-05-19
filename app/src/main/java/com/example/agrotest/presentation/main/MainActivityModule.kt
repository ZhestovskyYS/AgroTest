package com.example.agrotest.presentation.main

import androidx.lifecycle.ViewModel
import com.example.agrotest.presentation.home.HomeFragment
import com.example.agrotest.presentation.home.HomeModule
import com.example.agrotest.presentation.weights.WeightsFragment
import com.example.agrotest.presentation.weights.WeightsModule
import com.example.agrotest.presentation.weights.WeightsViewModel
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
}