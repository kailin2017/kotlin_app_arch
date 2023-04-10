package com.kailin.kotlin_app_arch.api

import com.kailin.kotlin_app_arch.BuildConfig
import com.kailin.kotlin_app_arch.model.CafeNomad
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CafeApi {

    @GET("${BuildConfig.DOMAIN}/api/v1.2/cafes/{city}")
    suspend fun cafes(@Path("city") city: String): Response<List<CafeNomad>>
}