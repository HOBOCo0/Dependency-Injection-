package com.example.dependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {
//    @Provides
//    fun getFirebaseRepository():UserRepository{
//        return FirebaseRepository()
//    }


    // this is one way for doing this as we are simply returning the object of sqlRepository
    // by passing the object as the dagger will create it internally
//    @Provides
//    fun getSQLRepository(sqlRepository: SQLRepository):UserRepository{
//        return sqlRepository
//    }

    // we can also use @bind annotation
    @ApplicationScope
    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository):UserRepository
}

/*
 @Binds can be used when component is using module to create object and class is already defined with @Inject annotation
 */