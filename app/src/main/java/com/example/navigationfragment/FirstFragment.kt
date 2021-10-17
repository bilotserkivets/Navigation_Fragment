package com.example.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationfragment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        //Формування повідомлення для передавання іншому фрагменту
        var bundle = Bundle()
        bundle.putString("key", "Message Fragment1 for Fragment2")

        //Перехід на фрагмент 2 по кліку на кнопку з передачею інформації
        binding.firstBtnNext.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}