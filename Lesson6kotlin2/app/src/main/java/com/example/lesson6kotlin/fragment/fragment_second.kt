package com.example.lesson6kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson6kotlin.R
import com.example.lesson6kotlin.databinding.FragmentSecondBinding


class fragment_second : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    val items = listOf(
        ExampleModel("Item 1", "Description 1"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ,),
        ExampleModel("Item 2", "Description 2"),
        ExampleModel("Item 3", "Description 3"),
        ExampleModel("Item 4", "Description 4"),
        ExampleModel("Item 5", "Description 5"),
        ExampleModel("Item 6", "Description 6"),
        ExampleModel("Item 7", "Description 7"),
        ExampleModel("Item 8", "Description 8"),
        ExampleModel("Item 9", "Description 9"),
        ExampleModel("Item 10", "Description 10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ExampleAdapter(items)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }

}