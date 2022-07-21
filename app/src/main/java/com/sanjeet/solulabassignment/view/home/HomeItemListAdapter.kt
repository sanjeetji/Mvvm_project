package com.sanjeet.solulabassignment.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjeet.solulabassignment.databinding.RowItemBinding
import com.sanjeet.solulabassignment.model.ItemList

class HomeItemListAdapter : RecyclerView.Adapter<HomeItemListAdapter.ItemViewHolder>() {

    private var itemList = mutableListOf<ItemList>()

    fun setItemList(itemList: List<ItemList>) {
        this.itemList = itemList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemLists = itemList[position]
        holder.binding.itemData = itemLists
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}