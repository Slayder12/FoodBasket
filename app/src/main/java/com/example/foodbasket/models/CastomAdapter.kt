package com.example.foodbasket.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbasket.R

class CustomAdapter(private val items: MutableList<Item>) :
RecyclerView.Adapter<CustomAdapter.ItemViewHolder>()
{

    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(item: Item, position: Int)
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemNameTV: TextView = itemView.findViewById(R.id.checkNameItemTV)
        val priceItemTV: TextView = itemView.findViewById(R.id.checkPriceItemTV)
        val imageIV: ImageView = itemView.findViewById(R.id.imageIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.itemNameTV.text = item.name
        holder.priceItemTV.text = item.price.toString()
        holder.imageIV.setImageResource(item.image)

        holder.itemView.setOnClickListener{
            if (onItemClickListener != null){
                onItemClickListener!!.onItemClick(item, position)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

}