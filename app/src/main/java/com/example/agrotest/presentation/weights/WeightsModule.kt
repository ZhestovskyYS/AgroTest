package com.example.agrotest.presentation.weights

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WeightsModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeightsViewModel::class)
    fun bindsViewModel(viewModel: WeightsViewModel): ViewModel
}