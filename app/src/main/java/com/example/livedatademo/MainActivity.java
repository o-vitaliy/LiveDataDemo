package com.example.livedatademo;

import android.os.Bundle;
import android.view.View;

import com.example.livedatademo.ui.main.MainFragment;
import com.example.livedatademo.ui.repos.ReposFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }


    public void showRepos(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ReposFragment.newInstance())
                .commitNow();
    }
}
