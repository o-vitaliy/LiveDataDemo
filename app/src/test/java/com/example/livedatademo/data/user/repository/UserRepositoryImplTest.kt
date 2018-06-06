package com.example.livedatademo.data.user.repository

import com.example.livedatademo.data.user.datasource.UserDataSource
import com.example.livedatademo.data.user.entity.UserEntity
import com.example.livedatademo.domain.user.mapper.UserEntityToModelMapper
import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.runBlocking
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UserRepositoryImplTest {

    private val userDataSource by lazy {
        mock(UserDataSource::class.java).apply {
            `when`(getUser(NAME)).thenReturn(createUser())
            `when`(getUser(NAME)).thenReturn(createUser())
        }
    }


    private val userRepository by lazy {
        UserRepositoryImpl(
                userDataSource,
                UserEntityToModelMapper()
        )
    }

    @Test
    fun getUser() = runBlocking {
        val user: User = userRepository.getUser(NAME).await()
        assertThat(ID, equalTo(user.id))
        assertThat(NAME, equalTo(user.name))
    }


    companion object {
        const val ID = "ID"
        const val NAME = "NAME"
        const val LINK = "LINK"

        fun createUser(): UserEntity {
            val id = ID
            val name = NAME
            val link = LINK
            return UserEntity(id, name, link, link)
        }
    }
}