package com.example.returnpals.services



import com.amplifyframework.datastore.generated.model.UsersMongoDb

/**
 * Converts UI model to Amplify model.
 */
fun UsersMongoDbUIModel.toAmplifyModel(): UsersMongoDb {
    return UsersMongoDb.builder()
        .firstName(this.firstName)
        .lastName(this.lastName)
        .address(this.address)
        .email(this.email)
        .phoneNumber(this.phoneNumber)
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