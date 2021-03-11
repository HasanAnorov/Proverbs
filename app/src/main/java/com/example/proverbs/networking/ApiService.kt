package com.example.proverbs.networking

import com.example.proverbs.model.Folder

import com.example.proverbs.model.Proverb
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
@GET("https://maqollar.uz/wp-json/wp/v2/posts")
fun getAllProverbs(): Call<List<Proverb>>
@GET("https://maqollar.uz/wp-json/wp/v2/posts")
fun getAllFolders():Call<List<Folder>>

}