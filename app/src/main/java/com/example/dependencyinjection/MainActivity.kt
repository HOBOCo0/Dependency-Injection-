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
        // userRegistrationService have dependencies of EmailService and UserRepository

        DaggerUserRegistrationComponent.builder().build().inject(this)
        userRegistrationService.registerUser("xyz.com", "1112233")
    }
}
/*
problem :-
now suppose our main Activity needs 50 dependencies so we need to define 50 methods
in our our components which will return the required dependencies.

 so, there is another way for creating dependencies in dagger using Field Dependency Injection.

 what is happening here??

  we defined a inject() method in our component. And we passed a consumer(Main Activity) to it.
  we said dagger that we are passing my object whatever fields have @inject annotation provide me those objects
 */

