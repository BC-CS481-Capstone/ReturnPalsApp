package com.example.returnpals.dataRepository

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Address
import com.amplifyframework.datastore.generated.model.MailingList
import kotlin.random.Random

class AddressRepositoryAmplify:AddressRepository {


    override fun addNewAddress(address: String, name: String, result: (Boolean) -> Unit) {
        val userId = Random.nextInt(100000, 999999).toString()
        val addressJSON = "{" +
                    "formatted:"+address+
                    "street_address:"+ address+
                    "locality:" +address+
                    //"region:WA" +
                    "postal_code:"+address+
                    //"country:USA" +
                    "}"
        Log.i("MyAmplifyApp", addressJSON)
        val model = Address.builder().address(addressJSON).build()
        Log.i("MyAmplifyApp", model.toString())
        Log.i("MyAmplifyApp", "\n\n\n\n\n\n")
        Amplify.API.mutate(
            ModelMutation.create(MailingList.builder().email("Test").fullName("Test").postalCode("Test").message("Test").build()),
            {
                result(true)
                Log.i("MyAmplifyApp", "Address with id: ${it.data.id}")
            },
            {
                result(false)
                Log.e("MyAmplifyApp", "Create failed", it)
            }
        )
    }

    override fun deleteAddress(address:String,result:(Boolean)->Unit) {
        //TODO
    }

    override fun getAllAddresses(result:(Boolean,List<String?>)->Unit) {
        //TODO
    }


}