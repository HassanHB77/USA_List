package com.hassan.android.usastate.helper

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hassan.android.usastate.R

object UiHelper{

    fun cropImage(imageView: ImageView, src: Int, activity: Activity){
        Glide.with(activity)
            .load(src)
            .circleCrop()
            .into(imageView)
    }

    fun setImageRepublicanOrDemocrats(party: String, imageView: ImageView, activity: Activity){
        if (party == "Republican") {
            Glide.with(activity)
                .load(R.drawable.republicans)
                .circleCrop()
                .into(imageView)
        } else {
            Glide.with(activity)
                .load(R.drawable.democrats)
                .circleCrop()
                .into(imageView)
        }
    }
}