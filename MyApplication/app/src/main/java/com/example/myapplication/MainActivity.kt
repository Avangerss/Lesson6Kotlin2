package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
            // Переключение на второй фрагмент
            val secondFragment = SecondFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}