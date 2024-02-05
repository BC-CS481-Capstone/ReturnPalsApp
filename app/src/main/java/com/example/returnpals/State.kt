package com.example.returnpals

import android.location.Address
import java.time.LocalDate

// TODO: develop backend

enum class PricingPlan {
    BRONZE {
        override fun toString(): String { return "BRONZE" }
    },
    SILVER {
        override fun toString(): String { return "SILVER" }
    },
    GOLD {
        override fun toString(): String { return "GOLD" }
    },
    PLATINUM {
        override fun toString(): String { return "PLATINUM" }
    }
}

enum class PickupMethod {
    HANDOFF {
        override fun toString(): String { return "HANDOFF" }
    },
    DOORSTEP {
        override fun toString(): String { return "DOORSTEP" }
    }
}

enum class PackageLabelType {
    PHYSICAL {
        override fun toString(): String { return "PHYSICAL" }
    },
    DIGITAL  {
        override fun toString(): String { return "DIGITAL" }
    },
    QRCODE  {
        override fun toString(): String { return "QR CODE" }
    }
}

data class PackageInfo(
    val id: ULong,
    val label: String, // label is a filename
    val labelType: PackageLabelType,
    var description: String? = null, // additional info provided by user
)

data class PickupInfo (
    var date: LocalDate? = null,
    var address: Address? = null,
    var method: PickupMethod? = null,
    var packages: HashMap<ULong, PackageInfo> = hashMapOf(),
    var pricing: PricingPlan? = null,
)

// Currently used to assign a unique ID to each label in `ScheduleReturn.PackagesUI`
class IdManager {

    private var _next: ULong = 0u
    private var _freed: ArrayDeque<ULong> = ArrayDeque()

    // TODO: throw exception when no more ids are available
    // Gets a unique ID and marks said ID as in-use
    fun allot(): ULong {
        var id = _next
        if (_freed.size > 0) {
            id = _freed.last()
            _freed.removeLast()
        } else _next++
        return id
    }

    // Marks the ID as no longer in-use and allows it to be allotted again
    fun free(id: ULong) {
        _freed.add(id)
    }

}