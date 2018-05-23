package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import artem.osipov.jokedisplayer.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements MainActivityFragmentCallback{

    private EndpointsAsyncTask asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (asyncTask != null) asyncTask.setCallback(null);
    }


    @Override
    public void navigateToAJoke() {
        asyncTask = new EndpointsAsyncTask();
        asyncTask.setCallback(new EndpointsAsyncTask.EndpointsAsyncTaskCallback() {
            @Override
            public void gotJoke(String joke) {
                Intent intent = new Intent(MainActivity.this, JokeDisplayActivity.class);
                intent.putExtra(JokeDisplayActivity.EXTRA_JOKE, joke);
                startActivity(intent);
            }

            @Override
            public void failed() {
            }
        });
    }


}
