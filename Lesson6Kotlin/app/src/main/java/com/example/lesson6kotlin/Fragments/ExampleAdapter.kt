package com.example.lesson6kotlin.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleAdapter (private val data: List<ExampleModel>) :
    RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.( item_example) {
            val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
            val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(androidx.fragment.R.layout.item_example, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentItem = data[position]

            holder.titleTextView.text = currentItem.title
            holder.descriptionTextView.text = currentItem.description
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }
