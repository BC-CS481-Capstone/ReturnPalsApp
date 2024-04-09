package com.example.returnpals.composetools


import android.util.Log
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
import org.json.JSONObject
import java.io.File
import java.time.LocalDate


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
    val order : Returns
        get() = Returns.builder().userId("")
            .email("test12346789@testemailtestemail.com")
            .labelIds(listOf())
            .method(PickupMethod.DOORSTEP)
            .confrimationNumber("Lorem ipsum dolor sit amet")
            .address("Lorem ipsum dolor sit amet")
            .labelIds(listOf())
            .status(PickupStatus.ON_THE_WAY)
            .build();

//Function to upload the image
private fun uploadFile(key: String, file: File){
    Amplify.Storage.uploadFile(key, file,
        { Log.i("MyAmplifyApp", "Successfully uploaded: $key" ) },
        { error -> Log.e("MyAmplifyApp", "Upload failed", error) }
    )
}





}