package com.example.livedatademo.domain.user.mapper

import com.example.livedatademo.data.user.entity.UserEntity
import com.example.livedatademo.domain.base.BaseEntityToModelMapper
import com.example.livedatademo.domain.user.model.User

class UserEntityToModelMapper : BaseEntityToModelMapper<UserEntity, User> {

    override fun map(entity: UserEntity): User = with(entity) {
        User(
                id = id,
                name = name
        )
    }
}