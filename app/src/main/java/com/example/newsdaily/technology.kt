package com.example.newsdaily

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsdaily.databinding.FragmentTechnologyBinding


class technology : Fragment() {

   // private val key="xyzzzzsad"
    private var _binding:FragmentTechnologyBinding?=null
    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentTechnologyBinding.inflate(inflater,container,false)

        binding.facebook.setOnClickListener {

            val intent = Intent(context,TechnoActivity::class.java)
            intent.putExtra("URL1","facebook")
            context?.startActivity(intent)

        }

        binding.apple.setOnClickListener {

            val intent = Intent(context,TechnoActivity::class.java)
            intent.putExtra("URL1","apple")
            context?.startActivity(intent)

        }

        binding.amazon.setOnClickListener {

            val intent = Intent(context,TechnoActivity::class.java)
            intent.putExtra("URL1","amazon")
            context?.startActivity(intent)

        }

        binding.netflix.setOnClickListener {

            val intent = Intent(context,TechnoActivity::class.java)
            intent.putExtra("URL1","netflix")
            context?.startActivity(intent)

        }

        binding.google.setOnClickListener {

            val intent = Intent(context,TechnoActivity::class.java)
            intent.putExtra("URL1","google")
            context?.startActivity(intent)

        }







        return binding.root


    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}