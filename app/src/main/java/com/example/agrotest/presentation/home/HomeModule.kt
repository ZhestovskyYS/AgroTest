package com.example.agrotest.presentation.home

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindsViewModel(viewModel: HomeViewModel): ViewModel

}