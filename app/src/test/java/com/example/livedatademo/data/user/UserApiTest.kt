package com.example.livedatademo.data.user

import com.example.livedatademo.di.DaggerTestComponent
import com.example.livedatademo.di.modules.AppModule
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class UserApiTest {

    @Inject
    lateinit var retrofit: Retrofit

    lateinit var api: UserApi

    @Before
    fun setUp() {
        DaggerTestComponent.builder().appModule(
                AppModule(RuntimeEnvironment.application)
        ).build().inject(this)

        api = retrofit.create(UserApi::class.java)
    }

    @Test
    fun `load user with real name`() {
        val result = api.getUser(NAME)
        MatcherAssert.assertThat(result, Matchers.notNullValue())
    }

    @Test(expected = Exception::class)
    fun `load user with unreal name`() {
        val result = api.getUser(UNREAL_NAME)
        MatcherAssert.assertThat(result, Matchers.notNullValue())
    }


    companion object {

        const val NAME = "o-vitaliy"
        const val UNREAL_NAME = "!!!!!||||||!!!!!"

    }
}