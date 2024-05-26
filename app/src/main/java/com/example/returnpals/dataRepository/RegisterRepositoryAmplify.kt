package com.example.returnpals.dataRepository

import android.util.Log
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.example.returnpals.viewmodel.RegisterUserInfo


class RegisterRepositoryAmplify : RegisterRepository {

    override fun registerUser(registerUserInfo: RegisterUserInfo, errorMessage: (Boolean,String?) -> Unit) {
        val address = "{" +
                "formatted:"+registerUserInfo.address+'\n'+
                registerUserInfo.suiteNumber+'\n'+
                registerUserInfo.city+", "+registerUserInfo.postalCode+
                "street_address:" +registerUserInfo.address+
                "locality:" +registerUserInfo.city+
                //"region:WA" +
                "postal_code:"+registerUserInfo.postalCode+
                //"country:USA" +
                "}"
        val attributes = listOf(
            AuthUserAttribute(AuthUserAttributeKey.email(),registerUserInfo.email),
            AuthUserAttribute(AuthUserAttributeKey.phoneNumber(),registerUserInfo.phoneNumber),
            AuthUserAttribute(AuthUserAttributeKey.givenName(),registerUserInfo.firstName),
            AuthUserAttribute(AuthUserAttributeKey.familyName(),registerUserInfo.lastName),
            AuthUserAttribute(AuthUserAttributeKey.address(),address),
        )
        val options = AuthSignUpOptions.builder().userAttributes(attributes).build()


        Log.i("RegisterRepositoryAmplify",options.toString())
        Amplify.Auth.signUp(
            registerUserInfo.email,
            registerUserInfo.password1,
             options ,
            { result ->
                //result.isSignUpComplete should return false every time as the user needs to confirm email.
                errorMessage(true,null)
                Log.i("Amplify Auth", "Result: \n" + result.toString()) }
        ) { error ->
            errorMessage(false,error.message+"\n"+error.recoverySuggestion)
            Log.e("Amplify Auth", "Sign up failed", error) }
    }


}