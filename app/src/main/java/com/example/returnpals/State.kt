package com.example.returnpals

import android.location.Address
import android.net.Uri
import java.time.LocalDate

// TODO: develop backend

enum class PricingPlan {
    BRONZE {
        override fun toString(): String { return "Bronze" }
    },
    SILVER {
        override fun toString(): String { return "Silver" }
    },
    GOLD {
        override fun toString(): String { return "Gold" }
    },
    PLATINUM {
        override fun toString(): String { return "Platinum" }
    }
}

enum class PickupMethod {
    HANDOFF {
        override fun toString(): String { return "Handoff" }
    },
    DOORSTEP {
        override fun toString(): String { return "Doorstep" }
    }
}

enum class PackageLabelType {
    PHYSICAL {
        override fun toString(): String { return "Physical" }
    },
    DIGITAL  {
        override fun toString(): String { return "Digital" }
    },
    QRCODE  {
        override fun toString(): String { return "QR Code" }
    }
}

data class PackageInfo(
    val label: Uri = Uri.EMPTY, // label is a filename
    val labelType: PackageLabelType = PackageLabelType.PHYSICAL,
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
     * Returns a list with unique IDs assigned to all the items.
     */
    fun <T> allot(items: List<T>): List<Pair<Int, T>> {
        return items.associateBy { allot() }.toList()
    }

    /**
     * Marks the ID as no longer in-use and allows it to be allotted again.
     */
    fun free(id: Int) {
        _freed.add(id)
    }

}