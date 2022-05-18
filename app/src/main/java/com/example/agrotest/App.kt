package com.example.agrotest

import com.example.agrotest.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        initDagger()
        super.onCreate()
    }

    private fun initDagger() {
        appComponent = DaggerAppCompanent.builder()
            .application(this)
            .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent
}