package com.example.lesson1kotlin2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lesson1kotlin2.R
import com.example.lesson1kotlin2.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), OnClickable {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

    private val adapter = CriptoAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.firstRecyclerView.adapter = this.adapter
        this.adapter.setCryptoList(
            mutableListOf(
                Cryptocurrency("https://focus.ua/static/storage/thumbs/1200x630/7/50/8d9ab21d-7c1a0b8b5b2302cd5b6fb029e1cb9507.jpg?v=6642_1",
                    "Биткоин — это децентрализованная система, работающая на основе программного протокола и основанная на принципе прямого обмена между пользователями. Все транзакции в сети биткоина записываются в распределенный реестр данных — блокчейн, копия которого хранится в полной ноде, подключенной к глобальной сети биткоина."),
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(cryptocurrency: Cryptocurrency) {
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDetailFragment(cryptocurrency))
    }
}