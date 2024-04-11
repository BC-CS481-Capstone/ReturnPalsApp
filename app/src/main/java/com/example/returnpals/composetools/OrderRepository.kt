package com.example.returnpals.composetools


import android.util.Log
import com.amplifyframework.core.Amplify

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
import com.example.returnpals.services.Backend.getEmail
import java.io.File


//Data Class for everything needed in the repository
data class OrderRepository(private val customerId: String,

                           private var date: Temporal.Date,
                           private var address: String = "123 basic ave",
                           private var labels: List<Int>,
                           private var status: PickupStatus = PickupStatus.ON_THE_WAY,
                           private var hasImage: Boolean = false,
                           private var imageFile: File? = null,
                           private var confirmation: String = "0",
                           private var method: PickupMethod?

)  {
    //Sets selected date
    fun setDate(inDate : Temporal.Date){
        date = inDate
    }
    //Sets their address
    fun setAddress(inAddress : String){
        address = inAddress;
    }
    //Sets the status
    fun setStatus(inputEnum : PickupStatus ){
        status = inputEnum
    }
    //Gets customer ID
    fun getId() : String{
        return customerId;
    }
    //Gets Date
    fun getDate() : Temporal.Date{
        return date;
    }
    //Gets Address
    fun getAddress() : String{
        return address
    }
    //Gets Status
    fun getStatus() : String{
        return status.toString()
    }
    fun setMethod(input: PickupMethod ){
      method = input
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

        get() = Returns.Builder()
            .address(address)
            .email(getEmail())
            .confrimationNumber(confirmation)
            .date(date)
            .labelIds(labels)
            .method(method)
            .status(PickupStatus.ON_THE_WAY)
            .build()


//Function to upload the image
private fun uploadFile(key: String, file: File){
    Amplify.Storage.uploadFile(key, file,
        { Log.i("MyAmplifyApp", "Successfully uploaded: $key" ) },
        { error -> Log.e("MyAmplifyApp", "Upload failed", error) }
    )
}





}