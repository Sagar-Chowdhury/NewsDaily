package com.example.newsdaily

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsdaily.databinding.FragmentSportsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SportsFragment : Fragment() {


    private var _binding : FragmentSportsBinding? = null
    private val binding get() = _binding!!


    lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSportsBinding.inflate(inflater,container,false)



        getNews()


        return binding.root

    }


    private fun getNews() {

        val news=Sports.sp.getHeadLines("in","sports",1)

        val recy = binding.recycler69
        val pro = binding.progressBar


        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {

                    pro.visibility =View.GONE
                    recy.visibility = View.VISIBLE

                    Log.d("RetrofitLog", news.toString())
                    adapter = NewsAdapter(requireContext(), news.articles)

                   // val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler69)
                    recy.adapter = adapter

                    recy.layoutManager = LinearLayoutManager(requireContext())
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("RetrofitLog", "Error in fetching news", t)
            }


        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






}