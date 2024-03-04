package com.example.returnpals.services
import android.content.Context
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.example.returnpals.composetools.OrderRepository
/**Adds amplify backend on create code as tutorial examples provided.**/
object Backend {

    private const val TAG = "Backend"

    fun initialize(applicationContext: Context) : Backend {
        /**Adds amplify backend on create code as tutorial examples provided.**/
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.addPlugin(AWSApiPlugin()) // Initialize AWS API plugin
            Amplify.configure(applicationContext) // Configure Amplify
            println("Amplify configuration successful.")
        } catch (error: AmplifyException) {
            error.printStackTrace() // Log the error if configuration fails
        }
        return this
    }
    fun createOrder(order: OrderRepository){
        Amplify.API.mutate(
            ModelMutation.create(order.order),
            {response ->
                Log.i(TAG, "created")
                if(response.hasErrors()) {
                    Log.e(TAG, response.errors.first().message)
                } else {
                    Log.i(TAG, "Created Order with id: " + response.data.id)
                    if(order.getHasImage()){

                    }
                }
            },
            {error ->
                Log.e(TAG, "Create failed", error)}
        )

    }
}