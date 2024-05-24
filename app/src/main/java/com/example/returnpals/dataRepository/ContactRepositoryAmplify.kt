package com.example.returnpals.dataRepository

object ContactRepositoryAmplify : ContactRepository{
    override fun submitData(fullName: String, postalCode: String, email: String, message: String,result:(Boolean)->Unit) {

    }
}