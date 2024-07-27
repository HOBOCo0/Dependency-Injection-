package com.example.dependencyinjection

import android.provider.ContactsContract.CommonDataKinds.Email
import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(

    //@Inject tells dagger whenever you want to create object of this class you can call its constructor.
    // It tells dagger how to create object.

    // instead of creating object in this class we manually inject the object.
    private val userRepository: UserRepository,

    //this helps dagger to understand which object to create
    @Named("Email")
    private val notificationService: NotificationService
) {
    fun registerUser(email: String, pass: String) {
        userRepository.saveUser(email, pass)
        notificationService.send(email, "abc.com", "welcome")
    }
}

