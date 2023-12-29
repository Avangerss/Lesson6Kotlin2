package com.example.lesson2kotlin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson2kotlin.databinding.ItemCryptoBinding
import com.example.lesson2kotlin.data.model.CryptoModel

class CryptoAdapter :
    RecyclerView.Adapter<CryptoAdapter.CriptoViewHolder>() {

    private var cryptoList = mutableListOf<CryptoModel>()

    fun setCryptoList(crytoList: MutableList<CryptoModel>) {
        this.cryptoList = crytoList
    }

    inner class CriptoViewHolder(private val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(cryptoModels: CryptoModel) {
            binding.tvCryptoName.text = cryptoModels.text
            Glide.with(binding.imageKrypto).load(cryptoModels.image).into(binding.imageKrypto)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriptoViewHolder {
        return CriptoViewHolder(
            ItemCryptoBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: CriptoViewHolder, position: Int) {
        holder.onBind(cryptoList[position])
    }
}