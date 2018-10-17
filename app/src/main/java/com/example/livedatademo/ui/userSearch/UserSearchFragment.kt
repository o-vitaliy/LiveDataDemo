package com.example.livedatademo.ui.userSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.livedatademo.R
import com.example.livedatademo.databinding.SearchUserFragmentBinding
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.ui.base.BaseDaggerFragment
import com.example.livedatademo.ui.common.getViewModel
import com.example.livedatademo.ui.main.MainFragment
import com.example.livedatademo.ui.userSearch.items.UserItem
import com.example.livedatademo.ui.utils.textChanges
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.search_user_fragment.*
import javax.inject.Inject

class UserSearchFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var binding: SearchUserFragmentBinding? = null

    private val vm by lazy {
        getViewModel<UserSearchViewModel>(viewModelFactory)
    }

    override fun inject(component: AppComponent) = component.inject(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_user_fragment, container, false)
        binding?.vm = vm
        binding?.setLifecycleOwner(this)
        binding?.searchResultsList?.adapter = GroupAdapter<ViewHolder>().apply {
            setOnItemClickListener { item, view ->
                val i = item as UserItem
                val bundle = bundleOf(MainFragment.ARG_USERNAME to i.user.name)
                findNavController().navigate(R.id.action_userSearchFragment_to_mainFragment, bundle)
            }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName.textChanges {
            vm.inputNameChange(it.toString())
        }
    }
}