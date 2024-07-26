package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject


interface UserRepository{
    fun saveUser(email: String, pass: String)
}
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

