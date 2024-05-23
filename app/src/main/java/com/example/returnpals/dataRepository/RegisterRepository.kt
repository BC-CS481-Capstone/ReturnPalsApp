package com.example.returnpals.dataRepository

import com.example.returnpals.viewmodel.RegisterUserInfo

interface RegisterRepository {

    fun registerUser(registerUserInfo: RegisterUserInfo, errorMessage:(String?)->Unit)

}

