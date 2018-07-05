package com.example.livedatademo.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.livedatademo.data.net.ClientFactory
import com.example.livedatademo.data.net.GsonFactory
import com.example.livedatademo.data.net.RetrofitFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ua.kyivstar.mobile.visa.core.di.qualifier.ApiUrl
import javax.inject.Singleton


@Module
class AppModule(private val context: Context) {

    @ApiUrl
    @Singleton
    @Provides
    fun provideApiUrl() = "https://api.github.com/"

    @Singleton
    @Provides
    fun provideContext() = context


    @Singleton
    @Provides
    fun provideGson(): Gson = GsonFactory().create()

    @Singleton
    @Provides
    fun providePreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient = ClientFactory().create()

    @Singleton
    @Provides
    fun provideRetrofit(
            @ApiUrl apiUrl: String,
            httpClient: OkHttpClient,
            gson: Gson
    ): Retrofit = RetrofitFactory().create(apiUrl, httpClient, gson)

}