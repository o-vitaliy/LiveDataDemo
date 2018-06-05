package com.example.livedatademo.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livedatademo.R
import com.example.livedatademo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var biding: MainFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return biding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mViewModel.user.observe(this, Observer {
            biding?.user = it
        })

    }

    companion object {

        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}
