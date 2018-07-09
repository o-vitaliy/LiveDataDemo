package com.example.livedatademo.ui.repos.mappers

import com.example.livedatademo.domain.repos.model.Repo
import com.example.livedatademo.ui.base.BaseModelToItemViewlMapper
import com.example.livedatademo.ui.repos.items.RepoItem
import javax.inject.Inject

class RepoMapper @Inject constructor(): BaseModelToItemViewlMapper<Repo, RepoItem> {
    override fun map(model: Repo): RepoItem = RepoItem(model)
}