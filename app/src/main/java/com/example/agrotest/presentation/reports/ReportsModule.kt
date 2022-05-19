package com.example.agrotest.presentation.reports

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.repository.interfaces.ReportsRepository
import com.example.repository.mock.MockReportsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ReportsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReportsViewModel::class)
    fun bindsViewModel(viewModel: ReportsViewModel): ViewModel

    companion object {
        @Provides
        fun provideRepository(): ReportsRepository = MockReportsRepositoryImpl()
    }
}