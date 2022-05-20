package com.example.agrotest.presentation.settings

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SettingsModule {
    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun bindsViewModel(viewModel: SettingsViewModel): ViewModel
}