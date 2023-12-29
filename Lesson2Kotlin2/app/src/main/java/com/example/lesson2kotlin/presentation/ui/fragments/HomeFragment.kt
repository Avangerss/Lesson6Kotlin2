package com.example.lesson2kotlin.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lesson2kotlin.R
import com.example.lesson2kotlin.databinding.FragmentHomeBinding
import com.example.lesson2kotlin.presentation.ui.adapters.CryptoAdapter
import com.example.lesson2kotlin.data.model.CryptoModel

class HomeFragment : Fragment() {

    private var  _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val cryptoAdapter = CryptoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListener()
    }

    private fun initialize() = with(binding) {
        try {
            val args: HomeFragmentArgs by navArgs()
            args.crypto?.let {
                CryptoList.cryptoList.add(it)
                Log.e("cryptoList", "initialize: ${CryptoList.cryptoList}", )
            }
        }catch (excption: Exception) {
            Log.e("args", "initialize: ${excption.message}", )
        }
        crypto.adapter = cryptoAdapter
        cryptoAdapter.setCryptoList(CryptoList.cryptoList)
        binding.crypto.adapter = cryptoAdapter
    }

    private fun setupListener() {
        binding.btnAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}