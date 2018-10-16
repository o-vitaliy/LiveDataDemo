package com.example.livedatademo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedatademo.domain.user.model.User
import com.example.livedatademo.domain.user.usecase.GetUserUseCase
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val userMutable = MutableLiveData<User>()
    val user = userMutable as LiveData<User>

    private val loadingMutable = MutableLiveData<Boolean>()
    val loading = loadingMutable as LiveData<Boolean>

    init {
        loadUser()
    }

    private fun loadUser() {
        launch {
            getUserUseCase.beforeExecute = { loadingMutable.postValue(true) }
            getUserUseCase.terminated = { loadingMutable.postValue(false) }
            val r = getUserUseCase.execute(GetUserUseCase.Params("o-vitaliy"))
                    .await()
                    .data
            r?.let {
                userMutable.postValue(it)
            }
        }
    }
}
