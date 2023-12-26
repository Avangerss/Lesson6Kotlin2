package com.example.lesson5kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson5kotlin.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null
    private val dataList = createDataList()
    private val MyData = 0
    private val secondAdapter = SecondAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        fillAnimeList()
        setupRecyclerView()
    }