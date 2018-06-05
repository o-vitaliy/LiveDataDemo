package com.example.livedatademo.data.user.datasource

import com.example.livedatademo.data.user.UserApi
import com.example.livedatademo.data.user.entity.UserEntity
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RemoteUserDataSourceTest {

    lateinit var remoteUserDataSource: RemoteUserDataSource

    lateinit var api: UserApi

    @Before
    fun setUp() {
        api = mock(UserApi::class.java)
        remoteUserDataSource = RemoteUserDataSource(api)
    }

    @Test
    fun `success call for real user`() {
        `when`(api.getUser(REAL_NAME)).thenReturn(UserEntity("1", REAL_NAME, "link", "link"))
        val result = remoteUserDataSource.getUser(REAL_NAME)
        assertThat(result, notNullValue())
    }

    @Test(expected = RuntimeException::class)
    fun `fail call for unreal user`() {
        `when`(api.getUser(UNREAL_NAME)).thenThrow(RuntimeException("unreal user"))
        val result = remoteUserDataSource.getUser(UNREAL_NAME)
        assertThat(result, notNullValue())
    }

    companion object {
        const val REAL_NAME = "o-vitaliy"
        const val UNREAL_NAME = "!!!!!||||||!!!!!"
    }
}