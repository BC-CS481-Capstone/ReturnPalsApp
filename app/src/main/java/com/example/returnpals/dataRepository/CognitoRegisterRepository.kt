package com.example.returnpals.dataRepository

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Address
import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User
import com.example.returnpals.viewmodel.RegisterUserInfo

class CognitoRegisterRepository : RegisterRepository {

    override fun registerUser(registerUserInfo: RegisterUserInfo, errorMessage: (String?) -> Unit) {
        submitRegistration(firstName = registerUserInfo.firstName,
            lastName = registerUserInfo.lastName,
            email = registerUserInfo.email,
            address = registerUserInfo.address,
            phoneNumber = registerUserInfo.phoneNumber,
            errorMessage = errorMessage)
    }

    fun submitRegistration(firstName: String, lastName: String, email: String, address: String, phoneNumber: String,errorMessage: (String?) -> Unit ) {
        Log.i("CognitoRegisterRepository", "Submitting registration for user: $email")

        val user = User.builder()
            .email(email)
            .subscription(PricingPlan.BRONZE)
            .firstName(firstName)
            .lastName(lastName)
            .phone(phoneNumber)
            .build()

        Log.i("CognitoRegisterRepository", "User model built, starting mutation.")

        Amplify.API.mutate(
            ModelMutation.create(user),
            { response ->
                if (response.hasErrors()) {
                    Log.e("CognitoRegisterRepository", "Error during user registration: ${response.errors.first().message}")
                    errorMessage(response.errors.toString())
                } else {
                    Log.i("CognitoRegisterRepository", "User registered successfully with ID: ${response.data.id}")
                    val userId = response.data.id

                    val addressModel = Address.builder()
                        .address(address)
                        .userId(userId)
                        .nickName("Default")
                        .userEmail(email)
                        .build()

                    Log.i("CognitoRegisterRepository", "Address model built, starting mutation for address.")

                    Amplify.API.mutate(
                        ModelMutation.create(addressModel),
                        {
                            if (it.hasErrors()) {
                                Log.e("CognitoRegisterRepository", "Error creating address for $email: ${it.errors.first().message}")
                                errorMessage(it.errors.toString())
                            } else {
                                Log.i("CognitoRegisterRepository", "Address created successfully for $email")

                            }
                        },
                        {
                            Log.e("CognitoRegisterRepository", "Failed to create address due to network error: ${it.message}", it)
                           errorMessage(it.message)
                        }
                    )
                }
            },
            {
                Log.e("CognitoRegisterRepository", "Failed to register user due to network error: ${it.message}", it)
                errorMessage(it.message)
            }
        )
    }


}