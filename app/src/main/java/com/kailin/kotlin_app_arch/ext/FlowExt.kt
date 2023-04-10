package com.kailin.kotlin_app_arch.ext

import com.kailin.kotlin_app_arch.model.RepoState
import com.kailin.kotlin_app_arch.model.RepoStatus
import kotlinx.coroutines.flow.*
import retrofit2.Response
import kotlin.experimental.ExperimentalTypeInference
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

@OptIn(ExperimentalTypeInference::class)
fun <T : Any, R : RepoState<T>> retrofitFlow(
    rClass: KClass<R>,
    @BuilderInference block: suspend () -> Response<T>,
): Flow<R> =
    flow {
        val response = block()
        val state = when (response.code()) {
            200 -> reflectSuccess(response, rClass)
            302 -> reflectRedirect(response, rClass)
            401 -> reflectTokenExpired(rClass)
            else -> reflectFail(response, rClass)
        }
        emit(state)
    }.onStart {
        emit(reflectLoading(rClass))
    }.catch {
        emit(reflectThrow(it, rClass))
    }

private fun <T : Any, R : RepoState<T>> reflectSuccess(
    response: Response<T>,
    rClass: KClass<R>,
): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.Success
            1 -> response.body()
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}

private fun <T : Any, R : RepoState<T>> reflectRedirect(
    response: Response<T>,
    rClass: KClass<R>,
): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.Redirect
            4 -> response.headers()["location"]
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}

private fun <T : Any, R : RepoState<T>> reflectTokenExpired(rClass: KClass<R>): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.TokenExpired
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}

private fun <T : Any, R : RepoState<T>> reflectFail(response: Response<T>, rClass: KClass<R>): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.Fail
            2 -> response.message()
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}

private fun <T : Any, R : RepoState<T>> reflectThrow(throwable: Throwable, rClass: KClass<R>): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.Fail
            2 -> throwable.localizedMessage
            3 -> throwable
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}

private fun <T : Any, R : RepoState<T>> reflectLoading(rClass: KClass<R>): R {
    val primaryConstructor = rClass.primaryConstructor
    val parameters = primaryConstructor!!.parameters
    val arguments = parameters.associateWith { parameter ->
        when (parameter.index) {
            0 -> RepoStatus.Loading
            else -> null
        }
    }
    return primaryConstructor.callBy(arguments)
}
