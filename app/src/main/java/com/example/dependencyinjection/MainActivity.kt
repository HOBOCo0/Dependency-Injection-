package com.example.dependencyinjection

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // manually creating the objects/ dependencies
        val emailService = EmailService()
        val userRepository = UserRepository()


     /*    manually injecting the dependencies to other class
                but there is some problem it this if we have to use this class in other multiple
                files so we need to create these objects manually and we need to inject it .
                We can do this using dagger more efficiently.

      */
        val userRegistrationService = UserRegistrationService(userRepository, emailService)
        userRegistrationService.registerUser("xyz.com", "1112233")
    }
}
/*
we are trying to create user registration using manual DI  advantage:-

   1/ unit testing:- as we can see there are lot of dependency on other classes
                 so not possible to implement unit testing.

   2/ single Responsibility:- this class have multiple responsibility ideally class
                         should be responsible for only one thing (purpose for which it is made)

   3/ life time of the objects:- here objects lifetime is not sure when it will get destroyed.

   4/ Extensible:- It is not possible add additional functionality easily
                as we have to create new objects manually based on new functionality

 */
