package com.example.returnpals.services

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Labels
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PickupStatus
import com.amplifyframework.datastore.generated.model.Returns
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

class ScheduleReturnViewModel(
    pickup: PickupInfo = PickupInfo(),
    val navController: NavController? = null,
    private val minDate: LocalDate = LocalDate.now().minusDays(1),
    private val maxDate: LocalDate = LocalDate.now().plusYears(1),

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

    fun onSubmit() {

        /*

        val uris = mutableListOf<Uri>()
        info.packages.forEach {
            thing -> uris.add(thing.label)
        }
        val hasImage = info.packages.isNotEmpty()




        val order = OrderRepository(
            Backend.Profile.getID(),
            Backend.getEmail(),
            Temporal.Date(info.date.toString()),
            info.address.toString(),
            listOf(1, 2, 3),
            PickupStatus.ON_THE_WAY,
            hasImage,
            uris,

            method = info.method
        )
        */
        val returns = Returns.builder()
            .userId(Backend.getEmail())
            .address(info.address.toString())
            .email(Backend.getEmail())
            .confrimationNumber("")
            .method(PickupMethod.valueOf(info.method.toString()))
            .status(PickupStatus.ON_THE_WAY)
            .build()
        Amplify.API.mutate(ModelMutation.create(returns),{
            Log.i("backend",it.toString())
            if (!it.hasErrors()) {
                returnId = it.data.id
                _createReturnSuccessful.postValue(true)
            }
        },{
            _createReturnSuccessful.postValue(false)
        })
        Log.println(Log.INFO, "ScheduleReturnViewModel::onSubmit", info.toString())
    }
    fun submitLabels() {
        //Uploads a list of labels to the database
        //Post when succeful
        var uploaded = true
        info.packages.forEach {
            val record = Labels.builder().type(it.labelType).returnsId(returnId).image(it.label.toString()).build()
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