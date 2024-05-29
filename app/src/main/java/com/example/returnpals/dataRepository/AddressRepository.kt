package com.example.returnpals.dataRepository

interface AddressRepository {

    fun addNewAddress(address: String, name: String, result: (Boolean) -> Unit)

    fun deleteAddress(address:String,result:(Boolean)->Unit)

    fun getAllAddresses(result:(Boolean,List<String?>)->Unit)

}