package com.example.returnpals.data

import androidx.lifecycle.LiveData

interface RegistrationRepository {

    val submissionSuccessful: LiveData<Boolean?>
    suspend fun registerUser(userInfo:UserregisterInfo)

}

data class UserregisterInfo(val first_name:String,
                    val last_name:String,
                    val user_email:String,
                    val phone_number:String,
                    val billing_address:String,
                    val apt_number:String,
                    val city_name:String,
                    val postal_code:String,
                    val new_password: String,
                    val confirm_password:String
)

