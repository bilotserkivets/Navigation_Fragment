package com.example.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationfragment.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.tvFragment2.text = arguments?.getString("key")

         //Формування повідомлення для передавання іншому фрагменту
        var bundle = Bundle()
        bundle.putString("key2", "Message Fragment2 for Fragment3")

        //Перехід на фрагмент 3 по кліку на кнопку з передачею інформації
        binding.secondBtnNext.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }

        //Перехід на фрагмент 1 по кліку на кнопку
        binding.secondBtnBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}