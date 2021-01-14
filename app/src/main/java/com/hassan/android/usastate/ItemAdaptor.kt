package com.hassan.android.usastate

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hassan.android.usastate.model.Object

class ItemAdaptor(private val listOfItems: List<Object>, private val context: Context) :
    RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemHolder(view, context)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = listOfItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = listOfItems.size

}