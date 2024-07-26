package com.example.dependencyinjection

import android.provider.ContactsContract.CommonDataKinds.Email
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    //@Inject tells dagger whenever you want to create object of this class you can call its constructor.
    // It tells dagger how to create object.

    // instead of creating object in this class we manually inject the object.
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(email: String, pass: String) {
        userRepository.saveUser(email, pass)
        emailService.sendEmail(email, "abc.com", "welcome")
    }
}

