package com.example.livedatademo.data.net

import com.example.livedatademo.data.net.ResponseDeserializer.DEFAULT_ERROR_MESSAGE
import okhttp3.ResponseBody
import org.hamcrest.MatcherAssert.*
import retrofit2.Response
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.junit.rules.ExpectedException
import org.junit.Rule


class ResponseDeserializerTest {

    @get:Rule
    var thrown = ExpectedException.none()

    @Test
    fun `successful`() {
        val body = "body"
        val response = Response.success(body)

        assertThat(body, equalTo(ResponseDeserializer.deserializer(response)))
    }


    @Test()
    fun `fail with error message`() {
        val errorMessage = "404"
        val response = mock(Response::class.java).apply {
            `when`(isSuccessful).thenReturn(false)
            `when`(errorBody()).thenReturn(ResponseBody.create(null, errorMessage))
        }
        thrown.expectMessage(errorMessage)
        ResponseDeserializer.deserializer(response)
    }

    @Test()
    fun `fail with message`() {
        val errorMessage = "failed with message"
        val response = mock(Response::class.java).apply {
            `when`(isSuccessful).thenReturn(false)
            `when`(errorBody()).thenReturn(null)
            `when`(message()).thenReturn(errorMessage)
        }
        thrown.expectMessage(errorMessage)
        ResponseDeserializer.deserializer(response)
    }

    @Test()
    fun `fail without message`() {
        val errorMessage = DEFAULT_ERROR_MESSAGE
        val response = mock(Response::class.java).apply {
            `when`(isSuccessful).thenReturn(false)
                   }
        thrown.expectMessage(errorMessage)
        ResponseDeserializer.deserializer(response)
    }
}