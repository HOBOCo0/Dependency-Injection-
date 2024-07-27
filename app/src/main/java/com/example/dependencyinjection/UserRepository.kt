package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository{
    fun saveUser(email: String, pass: String)
}
@Singleton
class SQLRepository @Inject constructor():UserRepository{
    override fun saveUser(email: String, pass: String){
        Log.d("UserRegistration","User Saved in DBB")
    }
}

class FirebaseRepository: UserRepository{
    override fun saveUser(email: String, pass: String){
        Log.d("UserRegistration","User Saved in Firebase")
    }
}

