package com.example.dependencyinjection
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/*
    This component will create objects for consumer classes when they need,
    consumers will ask component to provide all the required objects
 */
@ApplicationScope
@Component(modules = [NotificationServiceModule::class,UserRepositoryModule::class])
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{

        // @BindInstance binds the value to the component
        fun create(@BindsInstance retryCount:Int):UserRegistrationComponent
    }
}