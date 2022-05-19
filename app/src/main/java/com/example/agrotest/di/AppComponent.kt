package com.example.agrotest.di

import com.example.agrotest.App
import com.example.agrotest.navigation.NavigationModule
import com.example.core.di.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@AppScope
@Component(
    modules = [
        ActivityModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        NavigationModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}