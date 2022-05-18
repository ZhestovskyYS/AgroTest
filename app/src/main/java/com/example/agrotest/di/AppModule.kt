package com.example.agrotest.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.agrotest.App
import com.example.core.di.ApplicationContext
import com.example.core.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    @ApplicationContext
    fun bindApplicationContext(application: App): Context

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}