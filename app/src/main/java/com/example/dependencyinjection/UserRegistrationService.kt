package com.example.dependencyinjection

import android.provider.ContactsContract.CommonDataKinds.Email
import javax.inject.Inject

class UserRegistrationService @Inject constructor(

    //@Inject tells dagger whenever you want to create object of this class you can call its constructor.
    // It tells dagger how to create object.

    // instead of creating object in this class we manually inject the object.
    private val userRepository: UserRepository,
    private val notificationService: NotificationService
) {
    fun registerUser(email: String, pass: String) {
        userRepository.saveUser(email, pass)
        notificationService.send(email, "abc.com", "welcome")
    }
}

/*
Problem :- what if this UserRepository and NotificationService is an interface and some classes are
            implementing it and they are passed in constructor (this way we can implement a loosely coupled dependencies)?
            Then how will this dependency injection is going to work ? Because dagger will not know which class to pick to create object for Interfaces.

Solution:- we have to tell dagger which implementation(class) to pick because we can not create objects of interfaces. By creating Module and Provides

 */


