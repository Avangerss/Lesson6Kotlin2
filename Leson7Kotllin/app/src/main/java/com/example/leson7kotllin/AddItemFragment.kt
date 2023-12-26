package com.example.leson7kotllin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddItemFragment:Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var imageUrlEditText: EditText
    private lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false) {

            fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)

                titleEditText = view.findViewById(R.id.titleEditText)
                imageUrlEditText = view.findViewById(R.id.imageUrlEditText)
                addButton = view.findViewById(R.id.addButton)

                addButton.setOnClickListener {
                    // Получаем данные из UI
                    val title = titleEditText.text.toString()
                    val imageUrl = imageUrlEditText.text.toString()

                    // Передача данных обратно в Fragment(A)
                    val fragmentA =
                        childFragmentManager.findFragmentById(androidx.fragment.R.id.fragment_container_view_tag)
                    if (fragmentA is ItemListFragment) {
                        fragmentA.isAdded(Item(title, imageUrl))
                    }
                    requireActivity().supportFragmentManager.popBackStack()
                }

                return View
            }
        }
    }}
