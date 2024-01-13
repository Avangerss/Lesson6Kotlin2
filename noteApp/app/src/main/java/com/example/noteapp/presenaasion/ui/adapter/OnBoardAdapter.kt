package com.example.noteapp.presenaasion.ui.adapter

class OnBoardAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardPageFirst()
            1 -> OnBoardPageSecond()
            else -> OnBoardPageThird()
        }
    }
}