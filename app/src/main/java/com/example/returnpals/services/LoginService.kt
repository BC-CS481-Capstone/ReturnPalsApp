package com.example.returnpals.services

class LoginService {
    fun encryptPass(pass:String):String {
        //Encrypts user passwords
        return pass
    }

    fun isEmail(email:String):Boolean {
        //Boolean test for valid email format  example@server.com
        return false
    }

    fun login(user:String,pass:String):Boolean{
        //Checks user's password and email to the server and verifies if logged in.
        return false
    }



}