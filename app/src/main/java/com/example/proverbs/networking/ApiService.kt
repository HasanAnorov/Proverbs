package com.example.proverbs.networking

import com.example.proverbs.model.Folder
import com.example.proverbs.model.Model
import com.example.proverbs.model.Proverb
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
@GET("wp-json/wp/v2/posts/")
fun getAllProverbs(): Call<List<Model>>
fun getAllFolders():Call<List<Folder>>

}