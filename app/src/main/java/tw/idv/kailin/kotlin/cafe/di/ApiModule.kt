package tw.idv.kailin.kotlin.cafe.di

import tw.idv.kailin.kotlin.cafe.util.connect.okhttp.OkHttpFactory
import tw.idv.kailin.kotlin.cafe.util.connect.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import tw.idv.kailin.kotlin.cafe.BuildConfig
import tw.idv.kailin.kotlin.cafe.api.CafeApi
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
        return OkHttpFactory.createOkHttp()
    }

    @DefaultRetrofit
    @Singleton
    @Provides
    fun providesDefaultRetrofit(@DefaultOkHttp okHttpClient: OkHttpClient): Retrofit {
        return RetrofitFactory.createRetrofit(okHttpClient, BuildConfig.DOMAIN)
    }

    @Singleton
    @Provides
    fun provideCafeApi(@DefaultRetrofit retrofit: Retrofit): CafeApi =
        retrofit.create(CafeApi::class.java)
}