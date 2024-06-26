package com.example.returnpals.dataRepository
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Returns
import com.amplifyframework.storage.s3.AWSS3StoragePlugin
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


/**Adds amplify backend on create code as tutorial examples provided.**/
object Backend {

    private const val TAG = "Backend"
    private var email = "";
    var Profile = ProfileRepository()
    var returnList = mutableSetOf <ReturnRepository>()


    fun initialize(applicationContext: Context) : Backend {
        /**Adds amplify backend on create code as tutorial examples provided.**/
        Log.i(TAG, "Initializing Amplify plugins.")
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.addPlugin(AWSApiPlugin()) // Initialize AWS API plugin
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.addPlugin(AWSS3StoragePlugin())
            Amplify.configure(applicationContext) // Configure Amplify

            println("Amplify configuration successful.")
        } catch (error: AmplifyException) {
            error.printStackTrace() // Log the error if configuration fails
            println("Error configuring Amplify: ${error.message}")
        }
        return this
    }
    fun resetEmail(){
        email = ""
        Log.i(TAG, "email reset$email")
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
    private val _proccessingReturns = MutableLiveData(false)
    val proccessingReturns: LiveData<Boolean> = _proccessingReturns
    fun orderRetrieval() { // TODO Rename to or move logic to repository
        _proccessingReturns.postValue(true)
        Log.i(TAG, "Order Retrieval Called")
        Amplify.API.query(
            ModelQuery.list(Returns::class.java),
            { response ->
                Log.i(TAG, response.toString())
                if (response.hasData()) {
                    returnList.clear()
                    response.data.forEach() { orderData ->


                            val list = listOf(1, 2, 3)

                            val order = ReturnRepository(
                                customerId = "",//TODO id and email removed from model
                                email = email,
                                status = orderData.status,
                                date =  orderData.date,
                                method = orderData.method,
                                labels = list,
                                address = orderData.address
                                                            )
                            returnList.add(order)



                    }
                }
                _proccessingReturns.postValue(false)
            },
            { Log.e(TAG, "Query failed", it) }
        )
    }
    fun copyStreamToFile(inputStream: InputStream, outputFile: File) {
        inputStream.use { input ->
            val outputStream = FileOutputStream(outputFile)
            outputStream.use { output ->
                val buffer = ByteArray(4 * 1024) // buffer size
                while (true) {
                    val byteCount = input.read(buffer)
                    if (byteCount < 0) break
                    output.write(buffer, 0, byteCount)
                }
                output.flush()
                output.close()
            }
        }
    }
}