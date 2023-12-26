package com.example.kotliin5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotliin5.databinding.ActivitySekondBinding

class SekondActivity : AppCompatActivity() {
    private val anime = mutableListOf<Manga>()
    private var binding: ActivitySekondBinding? = null
    private val animeAdapter = AnimeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySekondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        fillAnimeList()
        setupRecyclerView()
    }

    private fun fillAnimeList() {
        anime.apply {
            add(Manga(R.drawable.ic_launcher_background, "Icon1"))
            add(Manga(R.drawable.ic_launcher_background, "Icon2"))
            add(Manga(R.drawable.ic_launcher_background, "Icon3"))
            add(Manga(R.drawable.ic_launcher_background, "Icon4"))
        }
    }

    private fun setupRecyclerView() {
        binding?.animeRecycler?.adapter = animeAdapter
        animeAdapter.setData(anime)
    }
}