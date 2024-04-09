package com.example.returnpals.composetools


import android.util.Log
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

import com.example.returnpals.services.Backend
import java.time.LocalDate

//For this, email on login should be stored in Profile Repository.

data class ProfileRepository(
    private var nameFirst : String = "John",
    private var nameLast : String = "Doe",
    private var email : String = "JD@ReturnPal.com",
    private var expireDate : LocalDate = LocalDate.now(),
    private var memberShipType : PricingPlan = PricingPlan.BRONZE
) {
    private val TAG = "ProfileRepo"
    fun getDataBase(){
        email = Backend.getEmail()
        Amplify.API.query(
            ModelQuery.list(User::class.java, User.EMAIL.contains(email)),
            { response ->
                Log.i("ProfileRepo", response.toString())
                if(response.hasData()) {
                    response.data.forEach { user ->
                        Log.i("ProfileRepo", user.firstName)
                        try {
                            nameLast = user.lastName
                        }   catch(except: Exception){
                            throw Exception(except)
                        }


                        try {
                            nameFirst = user.firstName
                        }   catch(except: Exception){
                            throw Exception(except)
                        }
                        try {
                            memberShipType = user.subscription
                        } catch(except: Exception){
                            //memberShipType = "none"
                        }
                    }
                }

            },
            { Log.e(TAG, "Query failed", it) }
        )
        Log.i(TAG, "$nameLast $nameFirst")
    }
    fun getFirstName() :String{
        return nameFirst
    }
    fun getLastName() : String{
        return nameLast
    }
    fun getType() : PricingPlan{
        return memberShipType
    }
    fun getExpireDate() : LocalDate{
        return expireDate
    }

}