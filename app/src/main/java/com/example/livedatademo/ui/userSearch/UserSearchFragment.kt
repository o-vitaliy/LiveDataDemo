package com.example.livedatademo.ui.userSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.R
import com.example.livedatademo.databinding.SearchUserFragmentBinding
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.ui.base.BaseDaggerFragment
import com.example.livedatademo.ui.common.getViewModel
import com.example.livedatademo.ui.utils.textChanges
import kotlinx.android.synthetic.main.search_user_fragment.*
import javax.inject.Inject

class UserSearchFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: SearchUserFragmentBinding? = null

    private val vm by lazy {
        getViewModel<UserSearchViewModel>(viewModelFactory)
    }

    override fun inject(component: AppComponent) = component.inject(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.search_user_fragment, container, false)
        biding?.vm = vm
        biding?.setLifecycleOwner(this)
        return biding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName.textChanges {
            vm.inputNameChange(it.toString())
        }
    }
}