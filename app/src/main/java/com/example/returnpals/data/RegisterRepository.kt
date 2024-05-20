package com.example.returnpals.data

import com.example.returnpals.viewmodel.RegisterUserInfo

interface RegisterRepository {

    fun registerUser(registerUserInfo: RegisterUserInfo, errorMessage:(String?)->Unit)

}

