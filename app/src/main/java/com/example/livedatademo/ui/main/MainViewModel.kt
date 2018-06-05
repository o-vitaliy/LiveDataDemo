package com.example.livedatademo.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.livedatademo.RemoteUser
import com.example.livedatademo.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.lang.Thread.sleep

class MainViewModel : ViewModel() {

    val user = MutableLiveData<User>()

    init {
        loadUser()
    }

    private fun loadUser() {
        launch {
            user.postValue(RemoteUser().getRemoteUser())
        }
    }
}
