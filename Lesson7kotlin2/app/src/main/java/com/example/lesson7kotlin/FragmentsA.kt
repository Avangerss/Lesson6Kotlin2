package com.example.lesson7kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson7kotlin.Fragments.Game
import com.example.lesson7kotlin.Fragments.GameAdapter
import com.example.lesson7kotlin.databinding.FragmentFragmentsABinding


class FragmentsA : Fragment() {

    private lateinit var binding: FragmentFragmentsABinding
    private val gameAdapter = GameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFragmentsABinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectRecyclerView()
        setGameList()
    }

    private fun setGameList() = mutableListOf<Game>(

        Game(R.drawable.Cal_Of, "Call of Duty"),
        Game(R.drawable.Cyberpunk, "Cyberpunk"),
        Game(R.drawable.Dota, "Dota 2"),
        Game(R.drawable.Forza, "Forza Horizon 5"),
        Game(R.drawable.gta, "GTA 6"),
        )


    private fun connectRecyclerView() {
        binding.rvFragmentA.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = gameAdapter
        }
    }
}