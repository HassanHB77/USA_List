package com.hassan.android.usastate.recyclerview

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hassan.android.usastate.PERSON_ID
import com.hassan.android.usastate.R
import com.hassan.android.usastate.databinding.ListItemBinding
import com.hassan.android.usastate.model.Object

class ItemHolder(view: View, private val activity: Activity) : RecyclerView.ViewHolder(view) {

    private lateinit var item: Object

    init {
        val navController = activity.findNavController(R.id.fragment_host_nav)
        itemView.setOnClickListener {
            Log.d("Test", "Go to Full details")
            val args = Bundle().apply {
                putInt(PERSON_ID, item.person.cspanid)
            }
            navController.navigate(R.id.action_listFragment_to_detailsFragment, args)
        }
    }

    val binding: ListItemBinding = ListItemBinding.bind(view)
    fun bind(item: Object) {
        this.item = item
        if (item.party == "Republican") {
            Glide.with(activity)
                .load(R.drawable.republicans)
                .circleCrop()
                .into(binding.logo)
        } else {
            Glide.with(activity)
                .load(R.drawable.democrats)
                .circleCrop()
                .into(binding.logo)
        }

        binding.description.text = item.description
        binding.party.text = item.party
        val onlyName = item.person.name.substring(5,item.person.name.indexOf('['))
        binding.senatorName.text = onlyName
    }
}