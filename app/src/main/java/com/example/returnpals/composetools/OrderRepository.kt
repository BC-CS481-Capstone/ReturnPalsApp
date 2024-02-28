package com.example.returnpals.composetools


import java.io.File
import java.time.LocalDate
import java.util.Date


data class OrderRepository(private val customerId : String,
                           private var date : LocalDate = LocalDate.now(),
                           private var address : AddressItem = AddressItem(-1, "123 basic ave"),
                           private var status : String = "N/A",
                           private var imageFile : File? = null,
                           private var notes : String = "N/A")  {

    fun setDate(inDate : LocalDate){
        date = inDate
    }
    fun setAddress(inAddress : AddressItem){
        address = inAddress;
    }
    fun setStatus(inStatus : String){
        status = "N/A"
    }
    fun getId() : String{
        return customerId;
    }
    fun getDate() : LocalDate{
        return date;
    }
    fun getAddress() : AddressItem{
        return address
    }
    fun getStatus() : String{
        return status
    }
    fun setImage(inFile : File){
        imageFile = inFile
    }
    fun getImage() : File? {
        return imageFile
    }




}