package com.example.livedatademo.data.repos.datasource

import com.example.livedatademo.data.repos.entity.RepoEntity

interface RepoDataSource {

    fun getRepos(name: String): List<RepoEntity>

}