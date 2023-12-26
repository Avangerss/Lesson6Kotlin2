package com.example.leson7kotllin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ItemDetailFragment: Fragment() {
    companion object {
        private const val ARG_ITEM = "arg_item"

        fun newInstance(item: Item): ItemDetailFragment {
            val fragment = ItemDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_ITEM, item)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_detail, container, false)

        val item: Item? = arguments?.getBundle(ARG_ITEM)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        item?.let {
            titleTextView.text = "Title: ${it.title}"

            // Загрузите изображение с использованием библиотеки Picasso или другой
            // (здесь предполагается использование Picasso)
            Picasso.get()
                .load(it.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(com.google.android.material.R.drawable.mtrl_ic_error)
                .into(imageView)
        }

        return view
    }
}