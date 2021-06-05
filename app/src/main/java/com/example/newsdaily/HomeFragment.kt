package com.example.newsdaily

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var adapter:NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getNews()

        return inflater.inflate(R.layout.fragment_home, container, false)



    }


    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("RetrofitLog", news.toString())
                    adapter = NewsAdapter(requireContext(), news.articles)
                    val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerHome)
                    val pro = view?.findViewById<ProgressBar>(R.id.progressBar2)
                    if (pro != null) {
                        pro.visibility = View.GONE
                    }
                    if (recyclerView != null) {
                        recyclerView.visibility = View.VISIBLE
                    }

                    if (recyclerView != null) {
                        recyclerView.adapter = adapter
                    }


                    if (recyclerView != null) {
                        recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    }
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("RetrofitLog", "Error in fetching news", t)
            }


        })
    }
}