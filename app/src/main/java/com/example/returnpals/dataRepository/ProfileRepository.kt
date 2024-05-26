package com.example.returnpals.dataRepository


import android.util.Log
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

//For this, email on login should be stored in Profile Repository.

data class ProfileRepository(//TODO Move State of UI to a view model
    private var nameFirst : String = "John",
    private var nameLast : String = "Doe",
    private var email : String = "JD@ReturnPal.com",
    private var expireDate : LocalDate = LocalDate.now(),
    private var ID :String = "N/A",

    private var memberShipType : PricingPlan = PricingPlan.SILVER

) {
    private val TAG = "ProfileRepo"
    fun getDataBase(){
        Amplify.Auth.fetchUserAttributes({
            it.iterator().forEach {
                if (it.key == AuthUserAttributeKey.givenName()) nameFirst = it.value
                if (it.key == AuthUserAttributeKey.email()) email = it.value
                if (it.key == AuthUserAttributeKey.familyName()) nameLast = it.value
            }

        }){}
        /*
        email = Backend.getEmail()
        Amplify.API.query(
            ModelQuery.list(User::class.java, User.EMAIL.contains(email)),
            { response ->
                Log.i("ProfileRepo", response.toString())
                if(response.hasData()) {
                    response.data.forEach { user ->
                        Log.i("ProfileRepo", user.firstName)
                        nameLast = try {
                            user.lastName
                        }   catch(except: Exception){
                            "Name"
                        }
                        ID = try {
                            user.id
                        } catch(except: Exception){
                            "ID"
                        }


                        nameFirst = try {
                            user.firstName
                        }   catch(except: Exception){
                            "User"
                        }
                        memberShipType = try {
                            user.subscription
                        } catch(except: Exception){

                            PricingPlan.BRONZE

                        }
                    }
                }

            },
            { Log.e(TAG, "Query failed", it) }
        )*/
        Log.i(TAG, "$nameLast $nameFirst")
    }
    fun getID() : String {
        return ID
    }
    fun getFirstName() :String{
        return nameFirst
    }
    fun getLastName() : String{
        return nameLast
    }

    fun getType() : String{
        return memberShipType.toString()

    }
    fun getExpireDate() : LocalDate{
        return expireDate
    }
}