package com.example.livedatademo.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livedatademo.R
import com.example.livedatademo.databinding.MainFragmentBinding
import com.example.livedatademo.ui.common.getViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: MainFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return biding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mViewModel = getViewModel<MainViewModel>(viewModelFactory)
        mViewModel.user.observe(this, Observer {
            biding?.user = it
        })
        mViewModel.loading.observe(this, Observer {
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
