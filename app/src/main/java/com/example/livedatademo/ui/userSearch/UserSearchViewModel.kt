package com.example.livedatademo.ui.userSearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedatademo.domain.search.usecase.SearchUserUseCase
import com.example.livedatademo.ui.userSearch.items.UserItem
import com.example.livedatademo.ui.userSearch.mappers.UserSearchMapper
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class UserSearchViewModel @Inject constructor(
        private val searchUserUseCase: SearchUserUseCase,
        private val userSearchMapper: UserSearchMapper
) : ViewModel() {

    val searchAdapter = MutableLiveData<List<UserItem>>()

    private val loadingMutable = MutableLiveData<Boolean>()
    val loading = loadingMutable as LiveData<Boolean>

    fun inputNameChange(userName: String) {
        launch {
            searchUserUseCase.beforeExecute = { loadingMutable.postValue(true) }
            searchUserUseCase.terminated = { loadingMutable.postValue(false) }
            searchUserUseCase.failed = { it.printStackTrace() }
            val r = searchUserUseCase.execute(SearchUserUseCase.Params(userName))
                    .await()
                    .data
                    ?.map { userSearchMapper.map(it) }
            r?.let { items ->
                try {
                    searchAdapter.postValue(items)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

}
