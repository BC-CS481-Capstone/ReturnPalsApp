package com.example.returnpals


import android.location.Address
import android.net.Uri
import java.time.LocalDate
import com.amplifyframework.datastore.generated.model.LabelType
// TODO: develop backend


data class PackageInfo(
    val label: String ="", // label is an absolute file path
    val labelType: LabelType,
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