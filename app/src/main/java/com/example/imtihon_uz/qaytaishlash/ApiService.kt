package com.example.imtihon_uz.qaytaishlash

import com.example.imtihon_uz.models.APIDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getMavels():Call<List<APIDataItem>>
}