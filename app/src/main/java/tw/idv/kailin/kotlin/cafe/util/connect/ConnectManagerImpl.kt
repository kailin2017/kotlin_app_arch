package tw.idv.kailin.kotlin.cafe.util.connect

import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import retrofit2.Response
import tw.idv.kailin.kotlin.cafe.repo.global.GlobalRepo
import javax.inject.Inject

class ConnectManagerImpl @Inject constructor(
    private val globalRepo: GlobalRepo,
) : ConnectManager {

    override suspend fun <T> call(block: suspend () -> Response<T>): T? = try {
        block().body()
    } catch (e: Exception) {
        globalRepo.emitThrowable(e)
        null
    }

    override suspend fun <T> callFlow(block: suspend () -> Response<T>): Flow<T> = flow {
        try {
            emit(block())
        } catch (e: Exception) {
            throw e
        }
    }.map {
        if (it.isSuccessful) {
            it.body()!!
        } else {
            throw HttpException(it)
        }
    }.catch {
        globalRepo.emitThrowable(it)
    }
}