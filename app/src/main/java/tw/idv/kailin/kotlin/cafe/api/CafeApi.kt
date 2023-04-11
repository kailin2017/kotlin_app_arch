package tw.idv.kailin.kotlin.cafe.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tw.idv.kailin.kotlin.cafe.BuildConfig
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

interface CafeApi {

    @GET("${BuildConfig.DOMAIN}/api/v1.2/cafes/{city}")
    suspend fun cafes(@Path("city") city: String): Response<List<CafeNomad>>
}