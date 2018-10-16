package com.example.livedatademo.ui.userSearch.mappers

import com.example.livedatademo.domain.user.model.User
import com.example.livedatademo.ui.base.BaseModelToItemViewlMapper
import com.example.livedatademo.ui.userSearch.items.UserItem
import javax.inject.Inject

class UserSearchMapper @Inject constructor() : BaseModelToItemViewlMapper<User, UserItem> {
    override fun map(model: User): UserItem = UserItem(model)
}