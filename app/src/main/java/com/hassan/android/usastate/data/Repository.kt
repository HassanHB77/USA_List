package com.hassan.android.usastate.data


import android.app.Activity
import com.hassan.android.usastate.model.Object
import java.util.*

object Repository {

    fun getPeople(activity: Activity): List<Object> {
        val unsortedList = getMainResponse(activity).objects
        val sortedList = unsortedList.sortedWith { p0, p1 ->
            p1?.person?.lastname?.let {
                p0?.person?.lastname?.compareTo(it) } ?: 0
        }
        return getMainResponse(activity).objects
    }
}