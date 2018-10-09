package com.example.livedatademo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.R
import com.example.livedatademo.databinding.MainFragmentBinding
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.ui.base.BaseDaggerFragment
import com.example.livedatademo.ui.common.getViewModel
import javax.inject.Inject

class MainFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: MainFragmentBinding? = null

    override fun inject(component: AppComponent) = component.inject(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return biding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = getViewModel<MainViewModel>(viewModelFactory)
        viewModel.user.observe(this, Observer {
            biding?.user = it
        })
        viewModel.loading.observe(this, Observer {
            biding?.loading = it
        })
    }

    companion object {

        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}
