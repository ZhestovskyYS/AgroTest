package com.example.agrotest.presentation.weightshistory

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.repository.interfaces.WeightsHistoryRepository
import com.example.repository.mock.MockWeightsHistoryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface WeightsHistoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(WeightsHistoryViewModel::class)
    fun bindsViewModel(viewModel: WeightsHistoryViewModel): ViewModel

    companion object {
        @Provides
        fun providesWeightsHistoryRepository(): WeightsHistoryRepository =
            MockWeightsHistoryRepositoryImpl()
    }
}