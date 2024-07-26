package com.example.dependencyinjection
import dagger.Component

/*
    This component will create objects for consumer classes when they need,
    consumers will ask component to provide all the required objects
 */

@Component
interface UserRegistrationComponent {

    // with the help of this dagger will create userRegistration Object when it is called directly in any class
    fun getUserRegistrationService():UserRegistrationService

    // with the help of this dagger will create emailService Object when it is called directly in any class
    fun getEmailService():EmailService
}