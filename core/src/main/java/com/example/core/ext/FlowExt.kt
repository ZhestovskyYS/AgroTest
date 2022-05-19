package com.example.core.ext

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T> Flow<T>.launchWhenCreated(
    scope: LifecycleCoroutineScope,
    body: suspend (value: T) -> Unit
): Job {
    return scope.launchWhenCreated { collect(body) }
}

fun <T> Flow<T>.launchWhenResumed(
    scope: LifecycleCoroutineScope,
    body: suspend (value: T) -> Unit
): Job {
    return scope.launchWhenResumed { collect(body) }
}