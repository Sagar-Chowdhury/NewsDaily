package com.example.newsdaily

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL1="https://newsapi.org/"
const val API_KEY1="964e7fe64d6b4492ba2710409d3445a9"

interface TechInterface{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("q") company: String, @Query("page") page: Int): Call<News>

}


object TechService
{
     val newsInstance:TechInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance=retrofit.create(TechInterface::class.java)

    }





}


