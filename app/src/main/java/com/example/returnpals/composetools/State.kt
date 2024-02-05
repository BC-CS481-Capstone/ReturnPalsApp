package com.example.returnpals.composetools

import android.location.Address
import java.time.LocalDate

// TODO: develop backend

data class PackageInfo(
    val label: String, // label is a filename
    val labelType: String,
    var description: String? = null, // additional info provided by user
)

data class PickupInfo (
    var date: LocalDate? = null,
    var address: Address? = null,
    var method: PickupMethod? = null,
    var packages: HashMap<Int, PackageInfo> = hashMapOf(),
    var pricing: Plan? = null,
)
