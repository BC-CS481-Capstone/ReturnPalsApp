package com.example.returnpals.services
import android.content.Context
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Orders
import com.amplifyframework.datastore.generated.model.UsersMongoDb
import com.example.returnpals.composetools.OrderRepository
import com.example.returnpals.composetools.ProfileRepository
import org.json.JSONObject
import java.time.LocalDate

/**Adds amplify backend on create code as tutorial examples provided.**/
object Backend {

     private const val TAG = "Backend"
    private var email = "";
    var Profile = ProfileRepository()
    var orderList = mutableSetOf <OrderRepository>()

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
                    orderList.add(order)
                    //if(order.getHasImage()){

                    //}
                }
            },
            {error ->
                Log.e(TAG, "Create failed", error)}
        )
    }
    fun resetEmail(){
        email = ""
        Log.i(TAG, "email reset" + email)
    }
    fun accessEmail(){
        Log.i(TAG, "Email Accessed $email")
        if(email == "") {
            Log.i(TAG, "It worked")
            Amplify.Auth.fetchUserAttributes(
                {
                    email = it[0].value
                    Log.i("AuthDemo", "User attributes = ${it.get(0).value}")
                    Profile.getDataBase()
                    orderRetrieval()

                },
                { Log.e("AuthDemo", "Failed to fetch user attributes", it) }
            )
        }

    }
    fun getEmail(): String{
        Log.i(TAG, "Email Retrieved $email")
        return email
    }
    private fun orderRetrieval() {
        Log.i(TAG, "Order Retrieval Called")
        Amplify.API.query(
            ModelQuery.list(Orders::class.java, Orders.ORDER_NUMBER.contains("9")),
            { response ->
                Log.i(TAG, response.toString())
                if (response.hasData()) {
                    response.data.forEach() { orderData ->
                        if (orderData.clientDetails.contains(email)) {
                            Log.i(TAG, "Order Added ${orderData.clientDetails}")
                            val order = OrderRepository(
                                email,
                                status = orderData.status,
                                date = orderData.orderDate,
                                notes = JSONObject(orderData.orderDetails)
                            )
                            orderList.add(order)
                        }


                    }
                }

            },
            { Log.e(TAG, "Query failed", it) }
        )
    }
}