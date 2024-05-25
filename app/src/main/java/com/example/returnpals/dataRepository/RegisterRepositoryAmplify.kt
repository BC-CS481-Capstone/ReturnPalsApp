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
                "formatted:address" +
                "street_address:address" +
                "locality:address" +
                "region:address" +
                "postal_code:98021" +
                "country:address" +
                "}"
        val attributes = listOf(
            AuthUserAttribute(AuthUserAttributeKey.email(),registerUserInfo.email),
            AuthUserAttribute(AuthUserAttributeKey.phoneNumber(),registerUserInfo.phoneNumber),
            AuthUserAttribute(AuthUserAttributeKey.givenName(),registerUserInfo.firstName),
            AuthUserAttribute(AuthUserAttributeKey.familyName(),registerUserInfo.lastName),
            AuthUserAttribute(AuthUserAttributeKey.address(),address),
        )
        val options = AuthSignUpOptions.builder().userAttributes(attributes).build()
        val options2 = AuthSignUpOptions.builder().
            userAttribute(AuthUserAttributeKey.phoneNumber(),registerUserInfo.phoneNumber)
            .userAttribute(AuthUserAttributeKey.givenName(),registerUserInfo.firstName)
            .userAttribute(AuthUserAttributeKey.familyName(),registerUserInfo.lastName)
            .userAttribute(AuthUserAttributeKey.address(),address)
            .userAttribute(AuthUserAttributeKey.email(),registerUserInfo.email)
            .build()
        Log.i("RegisterRepositoryAmplify",options.toString())
        Amplify.Auth.signUp(
            registerUserInfo.email,
            registerUserInfo.password1,
             options ,
            { result ->
                errorMessage(true,null)
                Log.i("Amplify Auth", "Result: \n" + result.toString()) }
        ) { error ->
            errorMessage(false,error.message+"\n"+error.recoverySuggestion)
            Log.e("Amplify Auth", "Sign up failed", error) }
    }


}