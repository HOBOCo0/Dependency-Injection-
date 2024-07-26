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

        val userRegistrationService = UserRegistrationService()
        userRegistrationService.registerUser("xyz.com","1112233")
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