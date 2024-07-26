package com.example.dependencyinjection

import android.provider.ContactsContract.CommonDataKinds.Email

class UserRegistrationService(
    // instead of creating object in this class we manually inject the object.
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(email: String, pass: String) {
        userRepository.saveUser(email, pass)
        emailService.sendEmail(email, "abc.com", "welcome")
    }
}

/*
we are trying to create user registration using manual DI advantage:-

   1/ unit testing:- to test this class we can inject dummy objects so unit testing can  be s easily done

   2/ single Responsibility:- this class is now having single responsibility of registering the
                    user earlier it had multiple responsibility as it was creating objects as well

   3/ life time of the objects:- here objects lifetime is independent of the class.

   4/ Extensible:- now It is possible add additional functionality easily
                as we have to create new objects manually based on new functionality

 */