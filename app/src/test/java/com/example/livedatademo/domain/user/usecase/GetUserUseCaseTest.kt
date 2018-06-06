package com.example.livedatademo.domain.user.usecase

import com.example.livedatademo.domain.user.UserRepository
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.*

class GetUserUseCaseTest {

    private val userRepository by lazy {
        mock(UserRepository::class.java)
    }


    private val getUserUseCase by lazy { GetUserUseCase(userRepository) }

    @Test
    fun execute() = runBlocking {
        val name = "some name"
        getUserUseCase.execute(GetUserUseCase.Params(name))

        verify(userRepository).getUser(name)
        verifyNoMoreInteractions(userRepository)

    }
}