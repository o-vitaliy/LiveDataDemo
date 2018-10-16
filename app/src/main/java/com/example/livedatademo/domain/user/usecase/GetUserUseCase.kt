package com.example.livedatademo.domain.user.usecase

import com.example.livedatademo.domain.base.BaseUseCase
import com.example.livedatademo.domain.user.UserRepository
import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.Deferred
import javax.inject.Inject

class GetUserUseCase
@Inject constructor(
        private val repository: UserRepository
) : BaseUseCase<GetUserUseCase.Params, User>() {

    override suspend fun run(params: Params): Deferred<User> = repository.getUser(params.name)

    data class Params(val name: String)
}