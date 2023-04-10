package com.kailin.kotlin_app_arch.util.connect

import com.kailin.kotlin_app_arch.util.connect.converter.JsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitHelper {

    fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(JsonConverterFactory())
            .build()
    }
}