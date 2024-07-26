package com.example.dependencyinjection

import android.util.Log

class EmailService {
    fun sendEmail(to:String, from:String, body:String){
        Log.d("UserRegistration","Email Sent")
    }
}

/*
we are trying to create user registration without DI  but here there are some problems

   1/ unit testing:- as we can see there are lot of dependency on other classes
                 so not possible to implement unit testing.

   2/ single Responsibility:- this class have multiple responsibility ideally class
                         should be responsible for only one thing (purpose for which it is made)

   3/ life time of the objects:- here objects lifetime is not sure when it will get destroyed.

   4/ Extensible:- It is not possible add additional functionality easily
                as we have to create new objects manually based on new functionality

 */