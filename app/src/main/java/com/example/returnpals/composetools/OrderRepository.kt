package com.example.returnpals.composetools


import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Orders
import org.json.JSONObject
import java.io.File
import java.time.LocalDate
import java.util.Date

//Data Class for everything needed in the repository
data class OrderRepository(private val customerId : String,

                           private var date : String = LocalDate.now().toString(),
                           private var address : String = "123 basic ave",

                           private var status : String = "N/A",
                           private var hasImage : Boolean = false,
                           private var imageFile : File? = null,
                           private var notes : JSONObject = JSONObject()
)  {
    //Sets selected date
    fun setDate(inDate : String){
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
    fun getDate() : String{
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
    fun setNotes(string1: String, string2: String){
        notes.put(string1, string2)

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
    val order : Orders
        get() = Orders.builder()
            .orderNumber("9")
            .orderDate(date)
            .status(status)
            .orderDetails(notes.toString())
            .clientDetails("{\n \"Email\" : \"{$customerId}\"}")
            .build()

//Function to upload the image
private fun uploadFile(key: String, file: File){
    Amplify.Storage.uploadFile(key, file,
        { Log.i("MyAmplifyApp", "Successfully uploaded: $key" ) },
        { error -> Log.e("MyAmplifyApp", "Upload failed", error) }
    )
}





}