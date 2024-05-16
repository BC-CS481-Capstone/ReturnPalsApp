package com.example.returnpals.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Labels
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.example.returnpals.PickupInfo
import com.example.returnpals.composetools.OrderRepository
import java.io.File
import java.time.LocalDate

/**
 * https://developer.android.com/jetpack/compose/state
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 * https://kotlinlang.org/docs/extensions.html#extension-functions
 */

/** Informative articles to learn more about how view-models work with Jetpack Compose:
 * https://developer.android.com/jetpack/compose/state-hoisting#viewmodels-as-state-owner
 * https://developer.android.com/topic/architecture/ui-layer/stateholders#ui-logic
 * https://developer.android.com/topic/libraries/architecture/viewmodel#best-practices
 * https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis
 */

class OrderViewModel(
    pickup: PickupInfo = PickupInfo(),
    val navController: NavController? = null,
    private val minDate: LocalDate = LocalDate.now().minusDays(1),
    private val maxDate: LocalDate = LocalDate.now().plusYears(1)
) : PickupViewModel(pickup) {

    //Condition Variable
    private val _createReturnSuccessful = MutableLiveData<Boolean?>()
    val createReturnSuccessful: LiveData<Boolean?> = _createReturnSuccessful
    private val _createLabelsSuccessful = MutableLiveData<Boolean?>()
    val createLabelsSuccessful: LiveData<Boolean?> = _createLabelsSuccessful

    //Extra data for returns
    var returnId = ""
    fun isValidDate(value: LocalDate): Boolean {
        return run {
            value > minDate && value < maxDate
        }.also {
            Log.println(Log.INFO, "ScheduleReturnViewModel::isValidDate", it.toString())
        }
    }

    fun onSubmit(email:String) {

        val uris = mutableListOf<String>()
        info.packages.forEach {
            thing -> uris.add(thing.label)
        }
        val hasImage = info.packages.isNotEmpty()

        val order = OrderRepository(
            Backend.Profile.getID(),
            email,
            Temporal.Date(info.date.toString()),
            info.address.toString(),
            listOf(1, 2, 3),
            PickupStatus.ON_THE_WAY,
            hasImage,
            uris,
            method = info.method
        )
        createOrder(order)

        Log.println(Log.INFO, "ScheduleReturnViewModel::onSubmit", info.toString())
    }

    fun submitLabels() {
        // Uploads a list of labels to the database
        // Post when successful
        var uploaded = true
        info.packages.forEach {
            val record = Labels.builder().type(it.labelType).returnsId(returnId).image(it.label).build()
            Amplify.API.mutate(ModelMutation.create(record),{
                Log.i("backend",it.toString())
                if(it.hasData() && !it.hasErrors()) {
                    uploaded = false
                }
            },{
                uploaded = false
            })
        }
        if (uploaded) {
            _createLabelsSuccessful.postValue(true)
        } else {
            _createLabelsSuccessful.postValue(false)
        }
    }
    private fun createOrder(returns: OrderRepository){
        Amplify.API.mutate(ModelMutation.create(returns.order),{
            Log.i("backend",it.toString())
            if (!it.hasErrors()) {
                returnId = it.data.id
                _createReturnSuccessful.postValue(true)
                Backend.orderList.add(returns)
                if(returns.getHasImage()) {
                    Log.i("Backend", "True checked")
                    returns.getImages().forEach { uri ->
                        val file = File(uri)
                        Amplify.Storage.uploadFile(
                            returnId, file,
                            { Log.i("Backend", "Successfully uploaded: $returnId") },
                            { error -> Log.e("Backend", "Upload failed", error) }
                        )

                    }
                }
            } else {
                Log.e("Backend", it.errors.first().message)
            }
        },{
            _createReturnSuccessful.postValue(false)
        })

    }

//    companion object {
//
//        // This determines the default value for the view-model that gets instantiated in navigation.
//        // https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                ScheduleReturnViewModel(
//                    navController = ,
//                )
//            }
//        }
//
//    }

}