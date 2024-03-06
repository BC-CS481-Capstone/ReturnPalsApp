package com.example.returnpals.composetools


import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Orders
import java.io.File
import java.time.LocalDate
import java.util.Date

//Data Class for everything needed in the repository
data class OrderRepository(private val customerId : String,
                           private var date : LocalDate = LocalDate.now(),
                           private var address : String = "123 basic ave",
                           private var status : String = "N/A",
                           private var hasImage : Boolean = false,
                           private var imageFile : File? = null,
                           private var notes : String = "N/A")  {
    //Sets selected date
    fun setDate(inDate : LocalDate){
        date = inDate
    }
    //Sets their address
    fun setAddress(inAddress : String){
        address = inAddress;
    }
    //Sets the status
    fun setStatus(inStatus : String){
        status = "N/A"
    }
    //Gets customer ID
    fun getId() : String{
        return customerId;
    }
    //Gets Date
    fun getDate() : LocalDate{
        return date;
    }
    //Gets Address
    fun getAddress() : String{
        return address
    }
    //Gets Status
    fun getStatus() : String{
        return status
    }
    //Sets Image and acknowledges it exists
    fun setImage(inFile : File){
        imageFile = inFile
        hasImage = true
    }
    //Gets the image if it exists
    fun getImage() : File? {
        return imageFile
    }
    //Gets value of hasImage
    fun getHasImage(): Boolean{
        return hasImage
    }
    //Sends the Order to database
    fun submitOrder(){
        val order = Orders.builder()
            .orderDate(date.toString())
            .status(status)
            .orderDetails("Test")
            .build()
        Amplify.API.mutate(ModelMutation.create(order),
            { Log.i("MyAmplifyApp", "Added Order with id: ${it.data.id}")},
            { Log.e("MyAmplifyApp", "Create failed", it)}
        )
        if(hasImage) {
            val setImage = imageFile as File
            uploadFile("TestKey", setImage)
        }

    }

//Function to upload the image
private fun uploadFile(key: String, file: File){


    Amplify.Storage.uploadFile(key, file,
        { Log.i("MyAmplifyApp", "Successfully uploaded: $key" ) },
        { error -> Log.e("MyAmplifyApp", "Upload failed", error) }
    )
}





}