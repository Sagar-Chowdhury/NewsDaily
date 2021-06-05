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


class FragmentForegein : Fragment() {

    lateinit var adapter: NewsAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val at = mutableListOf<Article>()
        at.add(Article("xyz","sddsd","assasas","xyz.pqr","https://cdn.vox-cdn.com/thumbor/N5K7jxY37GPYLWOiHwWLUm961fg=/0x46:2494x1352/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/22530228/MRiCWV1.jpeg"))

//        adapter= NewsAdapter(requireContext(),at)
//       recyclerView = view.findViewById(R)
//        recyclerView.adapter=adapter
        getNews()

        return inflater.inflate(R.layout.fragment_foregein, container, false)
    }

    private fun getNews() {
        val news=NewsService.newsInstance.getHeadLines("us",1)
        news.enqueue(object: Callback<News>
        {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if(news!=null)
                {
                    Log.d("RetrofitLog",news.toString())
                    adapter= NewsAdapter(requireContext(),news.articles)
                    val recyclerView= view?.findViewById<RecyclerView>(R.id.recyclerForegein)
                    val pro = view?.findViewById<ProgressBar>(R.id.progressBar4)
                    if (pro != null) {
                        pro.visibility = View.GONE
                    }
                    if (recyclerView != null) {
                        recyclerView.visibility = View.VISIBLE
                    }

                    if (recyclerView != null) {
                        recyclerView.adapter=adapter
                    }


                    if (recyclerView != null) {
                        recyclerView.layoutManager= LinearLayoutManager(requireContext())
                    }
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("RetrofitLog","Error in fetching news",t)
            }


        })


    }
    }



