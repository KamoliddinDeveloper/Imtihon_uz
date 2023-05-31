package com.example.imtihon_uz

import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.imtihon_uz.adapters.MyAdapters
import com.example.imtihon_uz.databinding.ActivityMainBinding
import com.example.imtihon_uz.models.APIDataItem
import com.example.imtihon_uz.qaytaishlash.ApiService
import com.example.imtihon_uz.qaytaishlash.ApliClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myRvadapters: MyAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Retrofit2()
    }

    private fun Retrofit2() {

        val apiService = ApliClient.getRetrofit().create(ApiService::class.java)
        apiService.getMavels()
            .enqueue(object : Callback<List<APIDataItem>> {
                override fun onResponse(
                    call: Call<List<APIDataItem>>,
                    response: Response<List<APIDataItem>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d(TAG, "onResponse: ${response.body()}")
                        binding.apply {
                            val dataList = response.body()
                            val adapter =
                                MyAdapters(dataList!!) // dataList o'rniga kerakli ma'lumotlar ro'yhatini o'tkazing
                            rv.adapter = adapter
                        }

                    }
                }

                override fun onFailure(call: Call<List<APIDataItem>>, t: Throwable) {

                    Toast.makeText(this@MainActivity, "Internet ulanmagan", Toast.LENGTH_SHORT)
                        .show()

                }

            })
    }

}