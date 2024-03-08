package com.example.returnpals.composetools


import java.time.LocalDate
//For this, email on login should be stored in Profile Repository.
data class ProfileRepository(
    private var nameFirst : String = "John",
    private var nameLast : String = "Doe",
    private var email : String = "JD@ReturnPal.com",
    private var expireDate : LocalDate = LocalDate.now(),
    private var memberShipType : String = "SILVER"
) {
    fun getDataBase(){
        /* Code is commented out for the time being, but should work with Amplify.
        Amplify.API.query(
            ModelQuery.list(UsersMongoDb::class.java, User.EMAIL.contains(email)),
            { response ->
                response.data.forEach { user ->
                    Log.i("MyAmplifyApp", user.nameFirst)
                    nameLast = user.nameLast
                    nameFirst = user.nameFirst
                    //We'll need to edit the data type of the ExpireDate in the database to LocalDate at some point
                    //Or use Strings, one of the two
                    //expireDate = user.expireDate
                    memberShipType = user.memberShipType
                }
            },
            { Log.e("MyAmplifyApp", "Query failed", it) }
        );
        */
    }
    fun getFirstName() :String{
        return nameFirst
    }
    fun getLastName() : String{
        return nameLast
    }
    fun getType() : String{
        return memberShipType
    }
    fun getExpireDate() : LocalDate{
        return expireDate
    }

}