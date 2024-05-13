package com.returnpal.androidapp.services

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.returnpal.androidapp.IdManager

class AddressesViewModel(
    addresses: List<String> = listOf(
        "123 Your Address One",
        "456 Your Address Two",
    )
) : ViewModel() {

    private val _addressIdManager: IdManager = IdManager()

    val selectedId = mutableStateOf<Int?>(null)
    val addresses = mutableStateMapOf(*_addressIdManager.allot(addresses).toTypedArray())

    val selectedAddress get() =
        if (selectedId.value != null)
            addresses[selectedId.value]
        else null

    fun onAddAddress(value: String) {
        val id = _addressIdManager.allot()
        addresses[id] = value
        selectedId.value = id
        Log.println(Log.INFO, "AddressesViewModel::onAddAddress", "Inserted key-value pair: { $id , ${addresses[id]} }")
    }

    fun onRemoveAddress(id: Int) {
        addresses.remove(id)
        _addressIdManager.free(id)
        Log.println(Log.INFO, "AddressesViewModel::onRemoveAddress", "Removed entry with key $id")
    }

    fun onSelectAddress(id: Int) {
        selectedId.value = id
        Log.println(Log.INFO, "PickupViewModel::onSelectAddress", "Updated value: ${selectedId.value}")
    }

}