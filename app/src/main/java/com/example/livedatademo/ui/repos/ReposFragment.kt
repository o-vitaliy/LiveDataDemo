package com.example.livedatademo.ui.repos

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livedatademo.R
import com.example.livedatademo.databinding.MainFragmentBinding
import com.example.livedatademo.databinding.ReposFragmentBinding
import com.example.livedatademo.ui.common.getViewModel
import com.example.livedatademo.ui.main.MainFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ReposFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: ReposFragmentBinding? = null

    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        biding = DataBindingUtil.inflate(inflater, R.layout.repos_fragment, container, false)

        return biding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = getViewModel<ReposViewModel>(viewModelFactory)

        viewModel.loading.observe(this, Observer {
            biding?.loading = it
        })

        viewModel.items.observe(this, Observer {
            it?.toMutableList()?.let {
                adapter.update(it)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        biding?.recyclerView?.adapter = adapter
        biding?.recyclerView?.layoutManager = LinearLayoutManager(context)
    }

    companion object {

        @JvmStatic
        fun newInstance(): ReposFragment {
            return ReposFragment()
        }
    }
}
