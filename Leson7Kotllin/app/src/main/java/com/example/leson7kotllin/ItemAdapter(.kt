package com.example.leson7kotllin

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class ItemAdapter(private val items: List<Item>, private val onItemClick: (Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_list, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        holder.titleTextView.text = currentItem.title

        // Загрузка изображения с использованием Picasso (или другой библиотеки)
        fun onBind(item: Item) = with( ) {
            Glide.with(holder.imageView.context)
                .load(currentItem.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(com.google.android.material.R.error)
                .into(holder.imageView)

            holder.itemView.setOnClickListener {
                onItemClick(currentItem)
            }
        }

         fun getItemCount() = items.size

        fun addItem(item: Item) {
            items.add(item)
            notifyDataSetChanged()
        }
    }
}