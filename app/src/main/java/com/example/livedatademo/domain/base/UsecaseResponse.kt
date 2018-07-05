package com.example.livedatademo.domain.base

class UsecaseResponse<R> private constructor(
        val status: UsecaseStatus
) {

    var data: R? = null
        private set
    var error: Throwable? = null
        private set

    companion object {
        fun <R > error(error: Throwable) =
                UsecaseResponse<R>(UsecaseStatus.Error).apply { this.error = error }

        fun <R> success(result: R) =
                UsecaseResponse<R>(UsecaseStatus.Done).apply {
                    data = result
                }
    }
}

