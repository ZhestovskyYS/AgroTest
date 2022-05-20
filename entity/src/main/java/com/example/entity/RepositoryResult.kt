package com.example.entity

sealed class RepositoryResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Initial<T> : RepositoryResult<T>()

    class Success<T>(data: T) : RepositoryResult<T>(data)

    class Error<T>(message: String?, data: T? = null) : RepositoryResult<T>(data, message)

    class Loading<T> : RepositoryResult<T>()
}