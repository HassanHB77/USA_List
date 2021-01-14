package com.hassan.android.usastate.model

import com.google.gson.annotations.SerializedName

data class Extra(
    val address: String,
    val contact_form: String,
    @SerializedName("end-type")
    val endType: String,
    val fax: String,
    val how: String,
    val office: String,
    val rss_url: String
)