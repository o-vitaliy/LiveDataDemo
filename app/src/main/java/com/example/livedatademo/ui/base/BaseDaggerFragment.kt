package com.example.livedatademo.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.livedatademo.App
import com.example.livedatademo.di.components.AppComponent

abstract class BaseDaggerFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject((context.applicationContext as App).appComponent)
    }

    abstract fun inject(component: AppComponent)
}