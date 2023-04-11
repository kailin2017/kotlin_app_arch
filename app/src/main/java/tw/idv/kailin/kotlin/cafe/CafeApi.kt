package tw.idv.kailin.kotlin.cafe

import tw.idv.kailin.kotlin.cafe.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CafeApi {

    @GET("${BuildConfig.DOMAIN}/api/v1.2/cafes/{city}")
    suspend fun cafes(@Path("city") city: String): Response<List<CafeNomad>>
}