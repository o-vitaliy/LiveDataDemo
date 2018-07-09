package com.example.livedatademo.data.repos.mapper

import com.example.livedatademo.data.repos.entity.RepoEntity
import com.example.livedatademo.data.base.BaseEntityToModelMapper
import com.example.livedatademo.domain.repos.model.Repo
import javax.inject.Inject

class RepoEntityToModelMapper @Inject constructor() : BaseEntityToModelMapper<RepoEntity, Repo> {

    override fun map(entity: RepoEntity): Repo = with(entity) {
        Repo(
                id = id,
                name = name
        )
    }
}