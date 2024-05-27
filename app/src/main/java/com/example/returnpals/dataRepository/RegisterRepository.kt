package com.example.returnpals.dataRepository

import com.example.returnpals.viewmodel.RegisterUserInfo

interface RegisterRepository {
    //>registerUser takes the view models state of the registerScreen and a callback
    // @result #Boolean = true when operation is a success
    //         #Boolean = false when failed operation
    //         #String = fail message
    fun registerUser(registerUserInfo: RegisterUserInfo, result:(Boolean,String?)->Unit)

}

