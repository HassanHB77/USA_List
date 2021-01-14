package com.hassan.android.usastate.data


import android.app.Activity
import com.hassan.android.usastate.model.Object

object Repository {

    fun getPeople(activity: Activity): List<Object>{
        return getMainResponse(activity).objects
    }

}