package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject

interface NotificationService{
    fun send(to:String, from:String, body:String?)
}
class EmailService @Inject constructor():NotificationService{

    override fun send(to: String, from: String, body: String?) {
        Log.d("UserRegistration","Email Sent")
    }
}

// retryCount will be passed during runtime
class MessageService(private val retryCount: Int):NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("UserRegistration","Message Sent - RetryCount - $retryCount")
    }

}

