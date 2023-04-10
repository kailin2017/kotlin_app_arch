package com.kailin.kotlin_app_arch.di

import com.kailin.kotlin_app_arch.BuildConfig
import com.kailin.kotlin_app_arch.api.CafeApi
import com.kailin.kotlin_app_arch.util.connect.OkHttpHelper
import com.kailin.kotlin_app_arch.util.connect.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultOkHttp

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultRetrofit

    @Singleton
    @DefaultOkHttp
    @Provides
    fun providesDefaultOkHttp(): OkHttpClient {
        return OkHttpHelper.createOkHttp()
    }

    @Singleton
    @DefaultRetrofit
    @Provides
    fun providesDefaultRetrofit(@DefaultOkHttp okHttpClient: OkHttpClient): Retrofit {
        return RetrofitHelper.createRetrofit(okHttpClient, BuildConfig.DOMAIN)
    }

    @Singleton
    @Provides
    fun provideCafeApi(@DefaultRetrofit retrofit: Retrofit) =
        retrofit.create(CafeApi::class.java)
}