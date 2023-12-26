package com.example.lesson5kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson5kotlin.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPlus.setOnClickListener {
            count++
            updateCount()
        }

        binding.btnMinus.setOnClickListener {
            count--
            updateCount()
        }

        // Восстановление состояния при повороте экрана
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0)
            updateCount()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    private fun updateCount() {
        binding.tvNuul.text = count.toString()

        // Переход ко второму фрагменту при достижении 10
        if (count == 10) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_activity_main, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}