package com.example.livedatademo.data.repos.repository

import com.example.livedatademo.data.repos.datasource.RepoDataSource
import com.example.livedatademo.data.repos.mapper.RepoEntityToModelMapper
import com.example.livedatademo.domain.repos.RepoRepository
import com.example.livedatademo.domain.repos.model.Repo
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val repoDataSource: RepoDataSource,
    private val repoEntityToModelMapper: RepoEntityToModelMapper
) : RepoRepository {
    override suspend fun getRepos(name: String): Deferred<List<Repo>> = async {
        val reposEntity = repoDataSource.getRepos(name)
        repoEntityToModelMapper.map(reposEntity)
    }
}