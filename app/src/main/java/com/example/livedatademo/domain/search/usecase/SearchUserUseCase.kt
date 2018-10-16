package com.example.livedatademo.domain.search.usecase

import com.example.livedatademo.domain.base.BaseUseCase
import com.example.livedatademo.domain.search.SearchRepository
import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

class SearchUserUseCase @Inject constructor(
        private val repository: SearchRepository
) : BaseUseCase<SearchUserUseCase.Params, List<User>>() {

    override suspend fun run(params: Params): Deferred<List<User>> = async {
        repository.searchUsers(params.query)
    }

    data class Params(val query: String)
}