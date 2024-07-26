package com.example.dependencyinjection
import dagger.Component

/*
    This component will create objects for consumer classes when they need,
    consumers will ask component to provide all the required objects
 */

@Component
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)
}