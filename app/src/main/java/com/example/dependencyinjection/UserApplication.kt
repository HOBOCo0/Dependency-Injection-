package com.example.dependencyinjection

import android.app.Application

class UserApplication: Application() {
    lateinit var appComponent: AppComponent
    // this will provide analytics service object
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}
