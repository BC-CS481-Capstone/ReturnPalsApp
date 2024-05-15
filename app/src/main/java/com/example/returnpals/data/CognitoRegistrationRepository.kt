package com.example.returnpals.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CognitoRegistrationRepository : RegistrationRepository {
    private val _submissionSuccessful = MutableLiveData<Boolean?>()
    override val submissionSuccessful: LiveData<Boolean?> = _submissionSuccessful

    override suspend fun registerUser(userInfo: UserregisterInfo) {
        TODO("Not yet implemented")
    }

}