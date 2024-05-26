package com.example.returnpals.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Labels
import com.example.returnpals.PickupInfo
import com.example.returnpals.composetools.OrderRepository
import com.example.returnpals.services.backend.LabelRepository
import com.example.returnpals.services.backend.PickupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    // Not sure if y'all knew, the pickup info object is stored in the pickup view model this inherits from

    private val _createReturnSuccessful = MutableLiveData<Boolean?>()
    val createReturnSuccessful: LiveData<Boolean?> = _createReturnSuccessful
    private val _createLabelsSuccessful = MutableLiveData<Boolean?>()
    val createLabelsSuccessful: LiveData<Boolean?> = _createLabelsSuccessful

    var returnId = ""

    fun isValidDate(value: LocalDate): Boolean {
        return run {
            value > minDate && value < maxDate
        }.also {
            Log.println(Log.INFO, "OrderViewModel::isValidDate", it.toString())
        }
    }

    fun onSubmit(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val pickup = info
            PickupRepository.create(pickup.copy(email=email).model) { model ->
                for (pack in pickup.packages) {
                    LabelRepository.create(pack.copy(returnId=model.id).model)
                }
            }
        }
    }

//    fun onSubmit(email: String) {
//        val uris = mutableListOf<String>()
//        this.packages.forEach { (_, pack) -> uris.add(pack.label) }
//        val hasImage = uris.isNotEmpty()
//
//        val order = OrderRepository(
//            Backend.Profile.getID(),
//            email,
//            Temporal.Date(this.date.toString()),
//            this.address.toString(),
//            listOf(1, 2, 3),
//            PickupStatus.ON_THE_WAY,
//            hasImage,
//            uris,
//            method = this.method
//        )
//        createOrder(order)
//
//        Log.println(Log.INFO, "OrderViewModel::onSubmit", this.info.toString())
//    }

    fun submitLabels() {
        var uploaded = true
        this.packages.forEach { (_, pack) ->
            val record = Labels.builder().type(pack.labelType).returnsId(returnId).image(pack.label).build()
            Amplify.API.mutate(ModelMutation.create(record), {
                Log.i("backend", it.toString())
                if (it.hasData() && !it.hasErrors()) {
                    uploaded = false
                }
            }, {
                uploaded = false
            })
        }
        if (uploaded) {
            _createLabelsSuccessful.postValue(true)
        } else {
            _createLabelsSuccessful.postValue(false)
        }
    }

    private fun createOrder(returns: OrderRepository) {
        Amplify.API.mutate(ModelMutation.create(returns.order), {
            Log.i("backend", it.toString())
            if (!it.hasErrors()) {
                returnId = it.data.id
                _createReturnSuccessful.postValue(true)
                Backend.orderList.add(returns)
                if (returns.getHasImage()) {
                    Log.i("Backend", "True checked")
                    returns.getImages().forEach { uri ->
                        val file = File(uri)
                        Amplify.Storage.uploadFile(
                            uri, file,
                            { Log.i("Backend", "Successfully uploaded: $uri") },
                            { error -> Log.e("Backend", "Upload failed", error) }
                        )
                    }
                }
            } else {
                Log.e("Backend", it.errors.first().message)
            }
        }, {
            _createReturnSuccessful.postValue(false)
        })
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

