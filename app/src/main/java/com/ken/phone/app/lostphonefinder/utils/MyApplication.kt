package com.ken.phone.app.lostphonefinder.utils

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

/*
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
*/
/*    @Provides
    @Singleton
    fun provideFirestoreInstance(
        application: Application
    ) = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuthInstance(

    ) = FirebaseAuth.getInstance()*//*


}*/
