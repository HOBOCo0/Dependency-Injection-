package com.example.dependencyinjection

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

/*
    This component will create objects for consumer classes when they need,
    consumers will ask component to provide all the required objects
 */

@ActivityScope // makes available throughout activity
@Subcomponent(
    modules = [NotificationServiceModule::class,
        UserRepositoryModule::class]
)
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {

        // @BindInstance binds the value to the component
        fun create(@BindsInstance retryCount: Int,): UserRegistrationComponent
    }
}