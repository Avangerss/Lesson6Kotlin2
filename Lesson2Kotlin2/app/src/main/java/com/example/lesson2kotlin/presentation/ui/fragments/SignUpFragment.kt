package com.example.lesson2kotlin.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson2kotlin.R
import com.example.lesson2kotlin.databinding.FragmentSignUpBinding
import com.example.lesson2kotlin.data.PreferenceHelper
import kotlin.math.log

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() = with(binding) {
        val preferenceHelper = PreferenceHelper(requireContext())
        btnSigne.setOnClickListener {
            preferenceHelper.userName = etName.text.toString().trim()
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}