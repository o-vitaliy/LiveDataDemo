package com.example.livedatademo.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.livedatademo.App
import com.example.livedatademo.di.components.AppComponent

abstract class BaseDaggerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject((application as App).appComponent)
    }

    abstract fun inject(component: AppComponent)
}