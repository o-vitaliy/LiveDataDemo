package com.example.livedatademo.domain.base

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

abstract class BaseUseCase<in P, out R> {

    var beforeExecute: (() -> Unit)? = null
    var afterExecute: (() -> Unit)? = null
    var failed: ((Throwable) -> Unit)? = null
    var terminated: (() -> Unit)? = null


    suspend fun execute(params: P): Deferred<UsecaseResponse<out R>> {
        beforeExecute?.invoke()

        var succeed = false
        try {
            val result = run(params).await()
            succeed = true
            return async {
                UsecaseResponse.success(result)
            }
        } catch (e: Exception) {
            succeed = false
            failed?.invoke(e)
            return async {
                UsecaseResponse.error<R>(e)
            }
        } finally {
            if (succeed) {
                afterExecute?.invoke()
            }

            terminated?.invoke()
        }

    }

    protected abstract suspend fun run(params: P): Deferred<R>
}