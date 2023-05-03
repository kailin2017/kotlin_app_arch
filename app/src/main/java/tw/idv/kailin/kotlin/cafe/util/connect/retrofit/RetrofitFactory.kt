package tw.idv.kailin.kotlin.cafe.util.connect.retrofit

import tw.idv.kailin.kotlin.cafe.util.connect.retrofit.JsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitFactory {

    fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(JsonConverterFactory())
            .build()
    }
}