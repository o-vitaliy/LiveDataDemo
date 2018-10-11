package com.example.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val finalHost = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host, finalHost)
                .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
                .commit()
    }
}
