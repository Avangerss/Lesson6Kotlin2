package com.example.mynoteshello.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynoteshello.R
import com.example.mynoteshello.databinding.FragmentOnBoardPageThirdBinding
import com.example.mynoteshello.ui.models.PreferencesHelper

class OnBoardPageThird : Fragment(R.layout.fragment_on_board_page_first) {

    private var _binding: FragmentOnBoardPageThirdBinding? = null
    private val binding get() = _binding!!
    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(context ?: requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPageThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStartClick()
    }

    private fun onStartClick() {
        binding.start.setOnClickListener {
            preferencesHelper.isShovOnBoard = true
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}