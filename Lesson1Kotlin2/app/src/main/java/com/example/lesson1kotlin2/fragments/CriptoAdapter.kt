package com.example.lesson1kotlin2.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson1kotlin2.databinding.ItemsBinding

class CriptoAdapter(val onClickable : OnClickable) : RecyclerView.Adapter<CriptoAdapter.CriptoViewHolder>() {

    private var criptoList = mutableListOf<Cryptocurrency>()

    fun setCryptoList(cryptoList: MutableList<Cryptocurrency>) {
        this.criptoList = cryptoList
    }
    inner class CriptoViewHolder(var binding: ItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(cryptocurrency: Cryptocurrency) {
            binding.tvCryptoName.text = cryptocurrency.text
            Glide.with(binding.imageKrypto).load(cryptocurrency.image).into(binding.imageKrypto)
            binding.root.setOnClickListener {
                onClickable.onClick(cryptocurrency)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriptoViewHolder {
        return CriptoViewHolder(
            ItemsBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return criptoList.size
    }

    override fun onBindViewHolder(holder: CriptoViewHolder, position: Int) {
        holder.onBind(criptoList[position])
    }
}

