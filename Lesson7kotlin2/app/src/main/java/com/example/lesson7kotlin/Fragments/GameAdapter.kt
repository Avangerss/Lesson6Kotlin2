package com.example.lesson7kotlin.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7kotlin.databinding.GameItemBinding

class GameAdapter: RecyclerView.Adapter<GameAdapter.GameHolder>() {

    private var gameList = mutableListOf<Game>()

    fun setGameList(list: MutableList<Game>) {
        gameList = list
    }
    class GameHolder (val item: GameItemBinding):RecyclerView.ViewHolder(item.root){
        fun bind (game: Game){
            item.ivGame.setImageResource(game.imageId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(
            GameItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.bind(gameList[position])
    }
}
