package com.example.vinu.rviewheaderdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomRecyclerViewAdapter(private val itemObjects: List<ItemObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER) {
            val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
            return HeaderViewHolder(layoutView)
        } else if (viewType == TYPE_ITEM) {
            val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ItemViewHolder(layoutView)
        }
        throw RuntimeException("No match for $viewType.")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mObject = itemObjects[position]
        if (holder is HeaderViewHolder) {
            holder.headerTitle.text = mObject.contents
        } else if (holder is ItemViewHolder) {
            holder.itemContent.text = mObject.contents
        }
    }

    private fun getItem(position: Int): ItemObject {
        return itemObjects[position]
    }

    override fun getItemCount(): Int {
        return itemObjects.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(itemObjects[position].header){
            TYPE_HEADER
        }else{
            TYPE_ITEM
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }
}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var headerTitle: TextView = itemView.findViewById<View>(R.id.header_id) as TextView

}
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemContent: TextView = itemView.findViewById<View>(R.id.item_content) as TextView

}