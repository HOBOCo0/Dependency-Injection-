package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository{
    fun saveUser(email: String, pass: String)
}
@ApplicationScope
class SQLRepository @Inject constructor(val analyticService: AnalyticService):UserRepository{
    override fun saveUser(email: String, pass: String){
        Log.d("UserRegistration","User Saved in DBB")
        analyticService.trackEvent("Save User","Create")
    }
}

class FirebaseRepository(val analyticService: AnalyticService): UserRepository{
    override fun saveUser(email: String, pass: String){
        Log.d("UserRegistration","User Saved in Firebase")
        analyticService.trackEvent("save User", "CREATE")
    }
}

