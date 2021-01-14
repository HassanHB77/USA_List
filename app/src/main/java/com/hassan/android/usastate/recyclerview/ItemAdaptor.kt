package com.hassan.android.usastate.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hassan.android.usastate.R
import com.hassan.android.usastate.model.Object

class ItemAdaptor(private val listOfItems: List<Object>, private val activity: Activity) :
    RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemHolder(view, activity)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = listOfItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = listOfItems.size

}