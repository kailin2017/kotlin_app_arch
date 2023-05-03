package tw.idv.kailin.kotlin.cafe.util.connect

import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ConnectManager {

    suspend fun <T> call(block: suspend () -> Response<T>): T?

    suspend fun <T> callFlow(block: suspend () -> Response<T>): Flow<T>
}