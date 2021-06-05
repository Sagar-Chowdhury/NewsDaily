package com.example.newsdaily

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL2="https://newsapi.org/"
const val API_KEY2="964e7fe64d6b4492ba2710409d3445a9"

interface SporsInter{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String,@Query("category")category:String, @Query("page") page: Int): Call<News>

}

object Sports
{
    val sp:SporsInter
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        sp =retrofit.create(SporsInter::class.java)

    }



}