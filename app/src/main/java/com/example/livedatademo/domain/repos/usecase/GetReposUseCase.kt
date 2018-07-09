package com.example.livedatademo.domain.repos.usecase

import com.example.livedatademo.domain.base.BaseUseCase
import com.example.livedatademo.domain.repos.RepoRepository
import com.example.livedatademo.domain.repos.model.Repo
import com.example.livedatademo.domain.user.UserRepository
import kotlinx.coroutines.experimental.Deferred
import javax.inject.Inject

class GetReposUseCase
@Inject constructor(
    private val repository: RepoRepository
) : BaseUseCase<GetReposUseCase.Params, List<Repo>>() {

    override suspend fun run(params: Params): Deferred<List<Repo>> = repository.getRepos(params.name)

    data class Params(val name: String)
}