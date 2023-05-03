package tw.idv.kailin.kotlin.cafe.repo.global

import kotlinx.coroutines.flow.Flow

interface GlobalRepo {

    val message: Flow<String>

    fun emitMessage(message: String)

    fun emitThrowable(throwable: Throwable)
}