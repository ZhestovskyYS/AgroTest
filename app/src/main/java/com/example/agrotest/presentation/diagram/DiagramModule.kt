package com.example.agrotest.presentation.diagram

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.repository.interfaces.DiagramRepository
import com.example.repository.mock.MockDiagramRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface DiagramModule {

    @Binds
    @IntoMap
    @ViewModelKey(DiagramViewModel::class)
    fun bindsViewModel(viewModel: DiagramViewModel): ViewModel

    companion object {
        @Provides
        fun provideDiagramRepository(): DiagramRepository = MockDiagramRepositoryImpl()
    }
}