package com.example.lesson1kotlin2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson1kotlin2.R
import com.example.lesson1kotlin2.databinding.FragmentSekondBinding
import com.example.lesson1kotlin2.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(), OnClickable {

    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding get() = _binding!!

    private val adapter = CriptoAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectRecyclerView()
    }

    private fun connectRecyclerView() {
        binding.thirdRecyclerView.adapter = this.adapter
        this.adapter.setCryptoList(
            mutableListOf(
                Cryptocurrency("https://happycoin.club/wp-content/uploads/2021/10/litecoin.jpg","Litecoin пиринговая электронная платёжная система, использующая одноимённую криптовалюту. Litecoin является вторым после Namecoin форком Bitcoin и имеет лишь небольшие отличия от него.")
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onClick(cryptocurrency: Cryptocurrency) {
        binding.thirdRecyclerView.setOnClickListener {
            findNavController().navigate(R.id.third_fagment)
        }
    }
}