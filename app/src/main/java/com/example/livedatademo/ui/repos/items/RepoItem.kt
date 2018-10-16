package com.example.livedatademo.ui.repos.items

import com.example.livedatademo.R
import com.example.livedatademo.databinding.RepoItemBinding
import com.example.livedatademo.domain.repos.model.Repo
import com.xwray.groupie.databinding.BindableItem

class RepoItem(private val repo: Repo) : BindableItem<RepoItemBinding>() {
    override fun bind(viewBinding: RepoItemBinding, position: Int) {
        viewBinding.repo = repo
    }

    override fun getLayout(): Int = R.layout.repo_item
}