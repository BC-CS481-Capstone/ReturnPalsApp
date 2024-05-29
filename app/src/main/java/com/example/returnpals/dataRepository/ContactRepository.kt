package com.example.returnpals.dataRepository

interface ContactRepository {
    fun submitData(fullName: String, postalCode: String, email: String, message: String,result:(Boolean,String)->Unit)
}