package com.example.lesson1kotlin2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson1kotlin2.databinding.FragmentSekondBinding

class SekondFragment : Fragment() {

    private var _binding: FragmentSekondBinding? = null
    private val binding: FragmentSekondBinding get() = _binding!!

    private val adapter = CriptoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSekondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        this.adapter.setCryptoList(
            mutableListOf(
                Cryptocurrency(
                    "https://media.istockphoto.com/id/1329407939/ru/%D1%84%D0%BE%D1%82%D0%BE/%D0%BA%D1%80%D0%B8%D0%BF%D1%82%D0%BE%D0%B2%D0%B0%D0%BB%D1%8E%D1%82%D0%B0-ethereum-%D1%84%D0%B8%D0%B7%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F-%D0%BC%D0%BE%D0%BD%D0%B5%D1%82%D0%B0-%D0%BF%D0%B5%D1%80%D0%B5%D0%B4-%D0%B0%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D1%8B%D0%BC-%D1%84%D0%BE%D0%BD%D0%BE%D0%BC.jpg?s=612x612&w=0&k=20&c=Oqx-5jra0sRL_HGejmLV2C9lhnE3kSS8Of99Z6p4XZk=",
                    "Эфириум также имеет свою собственную криптовалюту, называемую эфиром (ETH). Эфир работает на смарт-контрактах на языке программирования Solidity. Это особая «программа», которая, если выражаться простым языком, помогает «наладить взаимодействие» среди всех владельцев криптовалют."
                ),
                Cryptocurrency(
                    "https://trusteeglobal.com/wp-content/uploads/2022/07/stellar.png",
                    "Stellar является платформой для валютных операций, работающей в режиме реального времени (система валовых расчётов в режиме реального времени. Она была основана в начале 2014 года Джедом МакКалебом и Джойс Ким как ответвление от криптовалютной платформы Ripple для платёжных систем и первое время работала на одноимённом протоколе. В дальнейшем был разработан собственный open-source протокол Stellar. В процессе работы используется собственный вид электронной валюты, который ранее назывался стелларом или звездой, а теперь называется люменом (lumen) или XLM."
                ),
                Cryptocurrency(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiSbJGMwcQxodR34hImvQ2zEA3Y1dlfFztwiSZ-4NLbrv72duHj64WG7g___YAeTVV4d8&usqp=CAU",
                    "Binance Coin (BNB) – это криптовалюта, построенная по стандарту ERC20 от Ethereum и выпущенная известной криптовалютной биржей Binance. При помощи монет BNB пользователи биржи могут оплачивать комиссии за транзакции и получать за это дополнительные скидки. В первый год – 50%, во второй – 25%, в третий – 12.5%, в четвертый – 6.75%."
                )
            )
        )
        binding.sekondRecyclerView.adapter = this.adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}