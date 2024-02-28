package com.example.returnpals
import android.app.Application
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify

class ReturnPals : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            // Initialize AWS API plugin
            Amplify.addPlugin(AWSApiPlugin())
            // Initialize AWS Cognito Auth plugin
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            // Configure Amplify
            Amplify.configure(applicationContext)
            println("Amplify configuration successful.")
        } catch (error: AmplifyException) {
            error.printStackTrace() // Log the error if configuration fails
        }
    }
}