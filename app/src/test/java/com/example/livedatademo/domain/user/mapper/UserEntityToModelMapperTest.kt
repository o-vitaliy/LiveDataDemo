package com.example.livedatademo.domain.user.mapper

import com.example.livedatademo.data.user.entity.UserEntity
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.*
import org.junit.Test

class UserEntityToModelMapperTest {

    @Test
    fun `check mapper`() {
        val id = "id" + System.nanoTime()
        val name = "name" + System.nanoTime()
        val link = "link" + System.nanoTime()
        val userEntity = UserEntity(id, name, link, link)

        val mapper = UserEntityToModelMapper()
        val mappedUser = mapper.map(userEntity)


        assertThat(id, equalTo(mappedUser.id))
        assertThat(name, equalTo(mappedUser.name))
    }

    @Test
    fun `check mapper for list`() {

        val items = List(10) {
            val id = "id$it"
            val name = "name$it"
            val link = "link$it"
            val userEntity = UserEntity(id, name, link, link)

            val mapper = UserEntityToModelMapper()
            mapper.map(userEntity)
        }

        items.forEachIndexed { index, mappedUser ->
            assertThat("id$index", equalTo(mappedUser.id))
            assertThat("name$index", equalTo(mappedUser.name))
        }

    }
}
