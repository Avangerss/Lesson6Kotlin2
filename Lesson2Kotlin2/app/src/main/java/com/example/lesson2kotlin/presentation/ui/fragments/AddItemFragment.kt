package com.example.lesson2kotlin.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson2kotlin.R
import com.example.lesson2kotlin.databinding.FragmentAddItemBinding
import com.example.lesson2kotlin.databinding.FragmentHomeBinding
import com.example.lesson2kotlin.data.model.CryptoModel
class   AddItemFragment : Fragment() {

    private var  _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnAdd.setOnClickListener {

            val name = binding.etItem.text.toString().trim()
            val cryptoModel = CryptoModel("", name)
            Log.e("cryptoList", "setupListener: ${cryptoModel}", )
            findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToHomeFragment(cryptoModel))
        }
    }
}