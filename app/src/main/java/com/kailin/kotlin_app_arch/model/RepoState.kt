package com.kailin.kotlin_app_arch.model

enum class RepoStatus {
    Success, Fail, Loading, Redirect, TokenExpired, Empty
}

interface RepoState<T> {
    val status: RepoStatus
    val data: T?
    val message: String?
    val throwable: Throwable?
    val location: String?
}

