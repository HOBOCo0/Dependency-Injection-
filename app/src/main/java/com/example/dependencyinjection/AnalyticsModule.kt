package com.example.dependencyinjection

import dagger.Module
import dagger.Provides

@Module
class AnalyticsModule {
    @Provides
    fun getAnalyticsService():AnalyticService{
        return Mixpanel()
    }
}