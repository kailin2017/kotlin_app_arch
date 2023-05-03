package tw.idv.kailin.kotlin.cafe.repo.global

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import tw.idv.kailin.kotlin.cafe.di.ScopeModule
import java.net.UnknownHostException
import javax.inject.Inject

class GlobalRepoImpl @Inject constructor(@ScopeModule.IOScope private val scope: CoroutineScope) :
    GlobalRepo {

    private val _message = MutableStateFlow("")
    override val message: Flow<String> = _message

    override fun emitMessage(message: String) {
        scope.launch { _message.emit(message) }
    }

    override fun emitThrowable(throwable: Throwable) {
        when (throwable) {
            is HttpException -> emitMessage("HttpException: ${throwable.code()}")
            is UnknownHostException -> emitMessage("UnknownHostException")
            else -> emitMessage("Throwable: ${throwable.message}")
        }
    }
}