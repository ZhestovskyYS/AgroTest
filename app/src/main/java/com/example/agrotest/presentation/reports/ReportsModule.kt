package com.example.agrotest.presentation.reports

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ReportsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReportsViewModel::class)
    fun bindsViewModel(viewModel: ReportsViewModel): ViewModel
}