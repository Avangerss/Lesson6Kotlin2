package com.example.lesson5kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson5kotlin.databinding.FragmentItemBinding
import com.example.lesson5kotlin.databinding.FragmentSecondBinding

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.AnimeViewHolder>() {

    private var ic_iv = listOf<MyData>()

    fun setData(data: List<MyData>){
        ic_iv = data
    }
    class AnimeViewHolder(private val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(manga: MyData) = with(binding) {
            icIv.setImageResource(manga.param2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return ic_iv.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(ic_iv[position])
    }
}