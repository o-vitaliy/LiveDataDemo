package com.example.livedatademo.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedatademo.R
import com.example.livedatademo.databinding.ReposFragmentBinding
import com.example.livedatademo.di.components.AppComponent
import com.example.livedatademo.ui.base.BaseDaggerFragment
import com.example.livedatademo.ui.common.getViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class ReposFragment : BaseDaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var biding: ReposFragmentBinding? = null

    private val adapter = GroupAdapter<ViewHolder>()

    override fun inject(component: AppComponent) = component.inject(this)

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
