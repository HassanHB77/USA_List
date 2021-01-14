package com.hassan.android.usastate

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hassan.android.usastate.databinding.ListItemBinding
import com.hassan.android.usastate.model.Object

class ItemHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {


    //Republican  7mar   Democrats feel

    val binding: ListItemBinding = ListItemBinding.bind(view)
    fun bind(item: Object) {

        if (item.party == "Republican") {
            Glide.with(context)
                .load(R.drawable.republicans)
                .circleCrop()
                .into(binding.logo)
        } else {
            Glide.with(context)
                .load(R.drawable.democrats)
                .circleCrop()
                .into(binding.logo)
        }

        binding.description.text = item.description
        binding.party.text = item.party
        binding.senatorName.text = item.senator_class_label

    }

}