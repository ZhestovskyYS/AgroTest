package com.example.agrotest.di

import com.example.agrotest.presentation.main.MainActivity
import com.example.agrotest.presentation.main.MainActivityModule
import com.example.core.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeToMainActivity(): MainActivity
}