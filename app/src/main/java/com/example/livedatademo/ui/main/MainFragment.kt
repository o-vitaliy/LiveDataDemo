package com.example.livedatademo.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.livedatademo.R
import com.example.livedatademo.databinding.MainFragmentBinding
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.ui.base.BaseDaggerFragment
import com.example.livedatademo.ui.common.getViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: MainFragmentBinding? = null

    private val vm by lazy { getViewModel<MainViewModel>(viewModelFactory) }

    override fun inject(component: AppComponent) = component.inject(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val arguments = checkNotNull(arguments)
        val username = checkNotNull(arguments.getString(ARG_USERNAME))
        vm.loadUser(username)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return biding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openRepositories.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_reposFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = vm
        viewModel.user.observe(this, Observer {
            biding?.user = it
        })
        viewModel.loading.observe(this, Observer {
            biding?.loading = it
        })
    }


    companion object {
        const val ARG_USERNAME = "username"
    }
}
