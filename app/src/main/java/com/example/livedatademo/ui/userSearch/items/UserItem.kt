package com.example.livedatademo.ui.userSearch.items

import com.example.livedatademo.R
import com.example.livedatademo.databinding.UserItemBinding
import com.example.livedatademo.domain.user.model.User
import com.xwray.groupie.databinding.BindableItem

class UserItem(val user: User) : BindableItem<UserItemBinding>() {
    override fun bind(viewBinding: UserItemBinding, position: Int) {
        viewBinding.user = user
    }

    override fun getLayout(): Int = R.layout.user_item
}