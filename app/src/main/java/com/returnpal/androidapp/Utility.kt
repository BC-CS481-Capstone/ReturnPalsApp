package com.returnpal.androidapp

import com.amplifyframework.datastore.generated.model.LabelType
import com.amplifyframework.datastore.generated.model.PickupMethod
import com.amplifyframework.datastore.generated.model.PricingPlan
import java.time.LocalDate

fun PricingPlan.toNiceString(): String {
    return when (this) {
        PricingPlan.BRONZE -> "Bronze"
        PricingPlan.SILVER -> "Silver"
        PricingPlan.GOLD -> "Gold"
        PricingPlan.PLATINUM -> "Platinum"
    }
}

fun PickupMethod.toNiceString(): String {
    return when (this) {
        PickupMethod.HANDOFF -> "Handoff"
        PickupMethod.DOORSTEP -> "Doorstep"
    }
}

fun LabelType.toNiceString(): String {
    return when (this) {
        LabelType.PHYSICAL -> "Physical"
        LabelType.DIGITAL -> "Digital"
        LabelType.QRCODE -> "QR Code"
    }
}

fun LocalDate.toNiceString(): String {
    return this.month.name.lowercase().replaceFirstChar { it.uppercase() } + " " +
            this.dayOfMonth.toString() + ", " +
            this.year.toString()
}

fun filenameOf(filepath: String): String {
    val i = filepath.lastIndexOf('/')
    return if (i == -1) ""
    else filepath.substring(i + 1)
}

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