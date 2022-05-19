package com.example.agrotest

import com.example.agrotest.di.AppComponent
import com.example.agrotest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        initDagger()
        super.onCreate()
        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}