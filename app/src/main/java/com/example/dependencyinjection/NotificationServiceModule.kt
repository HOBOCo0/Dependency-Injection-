package com.example.dependencyinjection

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class NotificationServiceModule (){
    @ActivityScope
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
