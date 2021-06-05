package com.example.newsdaily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechnoActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techno)



        val comp =intent.getStringExtra("URL1")
       // Toast.makeText(this,"Techno Activity reached $comp",Toast.LENGTH_SHORT).show()
        if (comp != null) {
            getNews(comp)
        }

    }
    private fun getNews(str:String) {



        val news = TechService.newsInstance.getHeadLines(str,1)



        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("RetrofitLog", news.toString())
                    adapter = NewsAdapter(this@TechnoActivity, news.articles)
                    val recyclerView = findViewById<RecyclerView>(R.id.recy1)
                    val pro = findViewById<ProgressBar>(R.id.progressBar3)
                    pro.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE

                    if (recyclerView != null) {
                        recyclerView.adapter = adapter
                    }


                    if (recyclerView != null) {
                        recyclerView.layoutManager = LinearLayoutManager(this@TechnoActivity)
                    }
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("RetrofitLog", "Error in fetching news", t)
            }


        })
    }
}