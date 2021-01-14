package com.hassan.android.usastate

import android.app.Activity
import com.google.gson.Gson
import com.hassan.android.usastate.model.MainResponse
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

fun getMainResponse(activity: Activity): MainResponse{
    val gson = Gson()
    return gson.fromJson(loadJSONFromAsset(activity), MainResponse::class.java)
}

fun loadJSONFromAsset(activity: Activity): String? {
    var json: String? = null
    json = try {
        val `is`: InputStream = activity.assets.open("us_senators.json")
        val size: Int = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}