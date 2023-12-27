package com.example.lesson1kotlin2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.lesson1kotlin2.R
import com.example.lesson1kotlin2.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)// Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupListenere()
    }

    private fun setupListenere() {
        binding.btnGoback.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getData() {
        binding.tvDetail.text = args.modle.text
        Glide.with(binding.ivDetail).load(args.modle.image).into(binding.ivDetail)
    }
}
