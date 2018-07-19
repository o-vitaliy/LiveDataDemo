package com.example.livedatademo.data.user.mapper

import com.example.livedatademo.data.user.entity.UserEntity
import com.example.livedatademo.data.base.BaseEntityToModelMapper
import com.example.livedatademo.domain.user.model.User
import javax.inject.Inject

class UserEntityToModelMapper @Inject constructor() : BaseEntityToModelMapper<UserEntity, User> {

    override fun map(entity: UserEntity): User = with(entity) {
        User(
                id = id,
                name = name
        )
    }
}