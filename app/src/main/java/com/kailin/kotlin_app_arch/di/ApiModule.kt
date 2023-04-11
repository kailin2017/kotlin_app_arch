package com.kailin.kotlin_app_arch.di

import android.content.Context
import androidx.room.Room
import com.kailin.kotlin_app_arch.BuildConfig
import com.kailin.kotlin_app_arch.api.CafeApi
import com.kailin.kotlin_app_arch.dao.AppDatabase
import com.kailin.kotlin_app_arch.util.connect.OkHttpHelper
import com.kailin.kotlin_app_arch.util.connect.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultOkHttp

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultRetrofit

    @DefaultOkHttp
    @Singleton
    @Provides
    fun providesDefaultOkHttp(): OkHttpClient {
        return OkHttpHelper.createOkHttp()
    }

    @DefaultRetrofit
    @Singleton
    @Provides
    fun providesDefaultRetrofit(@DefaultOkHttp okHttpClient: OkHttpClient): Retrofit {
        return RetrofitHelper.createRetrofit(okHttpClient, BuildConfig.DOMAIN)
    }

    @Singleton
    @Provides
    fun provideCafeApi(@DefaultRetrofit retrofit: Retrofit): CafeApi =
        retrofit.create(CafeApi::class.java)
}