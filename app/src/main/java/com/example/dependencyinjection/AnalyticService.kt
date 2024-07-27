package com.example.dependencyinjection

import android.content.ContentValues.TAG
import android.util.Log

interface AnalyticService {
    fun trackEvent(eventName: String, eventType: String)
}
class Mixpanel: AnalyticService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG,"Mixpanel - $eventName - $eventType" )
    }

}
class FirebaseAnalytics: AnalyticService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG,"Firebase - $eventName - $eventType" )
    }
}