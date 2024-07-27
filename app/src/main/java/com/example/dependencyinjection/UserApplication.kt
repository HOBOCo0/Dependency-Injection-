package com.example.dependencyinjection

import android.app.Application

class UserApplication: Application() {
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(5)
    }
}

/*
this way we make the singleton object whose scope it through the application.
 note:-
 whatever singleton are there in the component there scope is throughout the component, so what matters
 is where you are defining your component
        if (component = Application level)
        {
            Scope is throughout the Application and there will be only one object instance
         }
         if(component = activity level)
         {
         so whenever there is new activity created or screen refreshes new objects will be created amd previous objects
         will be destroyed.
         }
 */