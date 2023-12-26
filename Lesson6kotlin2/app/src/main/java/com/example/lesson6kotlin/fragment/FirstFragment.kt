package com.example.lesson6kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson6kotlin.R
import com.example.lesson6kotlin.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.counterTextView.text = counter.toString()

        binding.plusButton.setOnClickListener {
            counter++
            updateCounterText()
        }

        binding.minusButton.setOnClickListener {
            counter--
            updateCounterText()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateCounterText() {
        binding.counterTextView.text = counter.toString()

        if (counter == 10) {
            val secondFragment = fragment_second()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}