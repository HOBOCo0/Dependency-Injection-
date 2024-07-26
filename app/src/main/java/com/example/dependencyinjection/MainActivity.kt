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

        // here all the dependencies are created by dagger and injected
        // userRegistrationService have dependencies of EmailService and UserRepository
        val userRegistrationService = DaggerUserRegistrationComponent.builder().build().getUserRegistrationService()
        val emailService = DaggerUserRegistrationComponent.builder().build().getEmailService()

        userRegistrationService.registerUser("xyz.com", "1112233")
    }
}

