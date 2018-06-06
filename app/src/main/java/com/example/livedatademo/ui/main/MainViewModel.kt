package com.example.livedatademo.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.livedatademo.RemoteUser
import com.example.livedatademo.domain.user.model.User
import kotlinx.coroutines.experimental.launch

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
