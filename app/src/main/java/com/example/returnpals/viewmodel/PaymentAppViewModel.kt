package com.example.returnpals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.returnpals.PickupInfo
import com.example.returnpals.dataRepository.PaymentAppRepositoryAmplify

class PaymentAppViewModel(
    val info: PickupInfo
): ViewModel() {
    //Condition variable for navigation.  Null until it is set to the correct navigation route
    private val _readyToNav = MutableLiveData<String?>(null)
    val readyToNav: LiveData<String?> = _readyToNav


    fun getPaymentSheet() {
        val price = "10.99" //TODO verify priceing
        PaymentAppRepositoryAmplify().getPaymentSheet(info.plan.toString(),price) {
            if (it) {

            }
        }
    }

}