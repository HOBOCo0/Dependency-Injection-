package com.example.dependencyinjection

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

// Before this addition of parameter the object of this module was created by dagger
// by calling its parameter but now we have to create the the object of the module.
@Module
class NotificationServiceModule (){
    @Singleton
    @MessageQualifier
    @Provides
    fun getMessageService(retryCount: Int):NotificationService{
        return MessageService(retryCount)
    }

    // we can use this named at te time of calling as well
    @Named("Email")
    @Provides
    fun getEmailService( emailService: EmailService):NotificationService{
        return emailService
    }
}


/*
problem:-
how and when to use qualifiers:-
    when we have multiple class implementing same interface and  interface type is passed as parameter and we want to create object then dagger will
    not be able to understand which class object to create so we can use qualifiers to give unique identity to objects.

    so, we  have @Named Qualifier

    and we can also create our own custom qualifiers to avoid typos
 */