package com.example.agrotest.presentation.weights

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.repository.interfaces.WeightsRepository
import com.example.repository.mock.MockWeightsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface WeightsModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeightsViewModel::class)
    fun bindsViewModel(viewModel: WeightsViewModel): ViewModel

    companion object {
        @Provides
        fun provideRepository(): WeightsRepository = MockWeightsRepositoryImpl()
    }
}