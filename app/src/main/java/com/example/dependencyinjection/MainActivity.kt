package com.example.dependencyinjection

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject // it tells these fields need injection (this is field injection)
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService: EmailService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // here all the dependencies are created by dagger and injected
        // userRegistrationService have dependencies of NotificationService and UserRepository (which are interfaces)

        // we are creating the module object using factory and passing the value in the component  so that dagger can use the value and create
        // the dependency and inject at the required fields or constructors
        (application as UserApplication).userRegistrationComponent.inject(this)
        userRegistrationService.registerUser("xyz.com", "1112233")
    }
}
/*
problem :-
Till now we wrote  code where the values is known at the compile time and the dagger
 was able to create object easily.but what if the values are provided aat the run-time and objects
 needs to be created based on the value. How to handle this ?

 so to solve this we have different methods:-
  what we will do is we will provide values to the dagger and dagger will provide objects to us.
    method 1-
      by creating the module object manually and passing the value to it so that dagger can create
      the dependency and inject at the required fields or constructors.
      problem- but sometimes developer might forget to create the module object
    method 2-
        By using factories(In general factories are used for creating objects)

 */

