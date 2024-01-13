package com.example.mynoteshello.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mynoteshello.R
import com.example.mynoteshello.databinding.FragmentViewPagerBinding
import com.example.mynoteshello.ui.adapters.OnBordAdapter

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        skipClick()
    }

    private fun skipClick() = with(binding) {
        onBoardViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                skip.isVisible = position != 2
            }
        })

        skip.setOnClickListener {
            onBoardViewPager.currentItem = 2
        }
    }

    private fun setupViewPager() = with(binding) {
        val onBoardAdapter = OnBordAdapter(this@ViewPagerFragment)
        onBoardViewPager.adapter = onBoardAdapter
        dotsIndicator.attachTo(onBoardViewPager)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
