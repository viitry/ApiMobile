package com.example.apianime.service

import com.example.apianime.SearchedAnime
import com.example.apianime.TopAnime
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("top/anime")
    fun getTopAnimes(): Call<TopAnime>

    @GET("search/anime")
    fun getSearchAnime(@Query("q")queryString: String): Call<SearchedAnime>

    companion object {
        val BASE_URL = "https://api.jikan.moe/v3/"

        fun create(): AnimeService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(AnimeService::class.java)
        }
    }
}