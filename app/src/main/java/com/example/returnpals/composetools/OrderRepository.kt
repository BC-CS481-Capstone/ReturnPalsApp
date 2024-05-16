package com.example.returnpals.composetools


import android.net.Uri
import android.util.Log
import com.amplifyframework.core.Amplify

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
import com.example.returnpals.services.Backend.getEmail
import java.io.File
import java.net.URI


//Data Class for everything needed in the repository
data class OrderRepository(private val customerId: String,
                           private val email: String,

                           private var date: Temporal.Date,
                           private var address: String = "123 basic ave",
                           private var labels: List<Int>,
                           private var status: PickupStatus = PickupStatus.ON_THE_WAY,
                           private var hasImage: Boolean = false,
                           private var images: List<String>? = listOf(),
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
    fun getConfirmation() : String{
        return confirmation
    }
    fun getMethod() : String{
        return when(method!!){
            PickupMethod.HANDOFF -> "Handoff"
            PickupMethod.DOORSTEP -> "Doorstep"
        }
    }

    //Sets Image and acknowledges it exists

    //Gets value of hasImage
    fun getHasImage(): Boolean{
        return hasImage
    }
    fun getImages(): List<String>{
        return images!!
    }
    //Sends the Order to database
    val order : Returns

        get() = Returns.Builder()
            .userId(customerId)
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