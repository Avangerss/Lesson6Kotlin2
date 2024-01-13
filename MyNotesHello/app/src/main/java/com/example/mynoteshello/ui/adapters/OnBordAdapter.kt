package com.example.mynoteshello.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mynoteshello.ui.fragments.onboard.OnBoardPageFirst
import com.example.mynoteshello.ui.fragments.onboard.OnBoardPageSecond
import com.example.mynoteshello.ui.fragments.onboard.OnBoardPageThird

class OnBordAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OnBoardPageFirst()
            1 -> OnBoardPageSecond()
            else -> OnBoardPageThird()
        }
    }
}