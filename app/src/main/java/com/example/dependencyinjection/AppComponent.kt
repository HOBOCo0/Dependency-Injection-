package com.example.dependencyinjection

import dagger.Component
import javax.inject.Singleton

// this will provide analytics service object
@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
    fun getUserRegistrationComponentFactory():UserRegistrationComponent.Builder
}