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
    val label: String, // label is a filename
    val labelType: PackageLabelType,
    var description: String? = null, // additional info provided by user
)

/**
 * Used to generate unique IDs by marking them as free or in-use and only giving freed ids.
 * Currently used to generate reference ids for items in a table.
 */
class IdManager {

    private var _next: Int = 1
    private var _freed: ArrayDeque<Int> = ArrayDeque()

    /**
     * Gets a unique ID and marks said ID as in-use.
     * If there are no more available ids then 0 is returned.
     */
    fun allot(): Int {
        var id = _next
        if (_freed.size > 0) {
            id = _freed.last()
            _freed.removeLast()
        } else if (_next != 0) {
            _next++
        }
        return id
    }

    /**
     * Marks the ID as no longer in-use and allows it to be allotted again.
     */
    fun free(id: Int) {
        _freed.add(id)
    }

}