package com.example.returnpals

import android.app.Application
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify

class ReturnPals : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            Amplify.addPlugin(AWSApiPlugin()) // Initialize AWS API plugin
            Amplify.configure(applicationContext) // Configure Amplify
            println("Amplify configuration successful.")
        } catch (error: AmplifyException) {
            error.printStackTrace() // Log the error if configuration fails
        }
    }
}