package com.example.returnpals.services



import com.amplifyframework.datastore.generated.model.PricingPlan
import com.amplifyframework.datastore.generated.model.User

/**
 * Converts UI model to Amplify model.
 */
fun UsersMongoDbUIModel.toAmplifyModel(): User {
    return User.builder().email(this.email)
        .subscription(PricingPlan.BRONZE)
        .firstName(this.firstName)
        .lastName(this.lastName)
        .phone(this.phoneNumber)
        .build()
}

/**
 * A UI model to represent mailing list data.
 */
data class UsersMongoDbUIModel(
    val firstName: String,
    val lastName: String,
    val address: List<String>,
    val email: String,
    val phoneNumber: String
)