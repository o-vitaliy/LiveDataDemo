package com.example.livedatademo.domain.base

import kotlinx.coroutines.experimental.Deferred

abstract class BaseUseCase<in P, out R> {

    abstract suspend fun execute(params: P): Deferred<R>
}