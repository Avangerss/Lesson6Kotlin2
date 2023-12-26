package com.example.kotliin5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kotliin5.databinding.ItemAnimeBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var anime = listOf<Manga>()

    fun setData(data: List<Manga>){
        anime = data
    }
    class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {

        fun onBind(manga: Manga) = with(binding) {
            animeCover.setImageResource(manga.image)
            animeTv.text = manga.title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        holder.onBind(anime[position])
    }

    override fun getItemCount(): Int = anime.size
}