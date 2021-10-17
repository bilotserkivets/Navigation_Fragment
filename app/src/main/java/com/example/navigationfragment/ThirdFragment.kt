package com.example.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationfragment.databinding.FragmentSecondBinding
import com.example.navigationfragment.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        //Отримання переданої інформації з фрагменту 2
        binding.tvFragment3.text = arguments?.getString("key2")

        //Перехід на фрагмент 2 по кліку на кнопку
        binding.thirdBtnBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_thirdFragment_to_secondFragment)
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = ThirdFragment()
    }
}