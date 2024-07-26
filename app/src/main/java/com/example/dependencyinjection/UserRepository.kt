package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun saveUser(email: String, pass: String){
        Log.d("UserRegistration","User Saved in DBB")
    }
}

