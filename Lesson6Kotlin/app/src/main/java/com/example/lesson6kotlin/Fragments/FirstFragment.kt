package com.example.lesson6kotlin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.R
import com.example.lesson6kotlin.databinding.FragmentBlankBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nul.text = counter.toString()

        binding.plus.setOnClickListener {
            counter++
            updateCounterText()
        }

        binding.minus.setOnClickListener {
            counter--
            updateCounterText()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateCounterText() {
        binding.nul.text = counter.toString()

        if (counter == 10) {
            // Переключение на второй фрагмент
            val secondFragment = fragment_second()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, secondFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}