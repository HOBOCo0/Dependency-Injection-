package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor(){
    fun sendEmail(to:String, from:String, body:String){
        Log.d("UserRegistration","Email Sent")
    }
}

