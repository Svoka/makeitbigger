package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by artemosipov on 23/05/2018.
 */

@RunWith(AndroidJUnit4.class)
public class JokeRetrieveTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void jokeSuccessfullyRetrieving() throws Exception{
        String result = null;
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute();

        try {
            result = asyncTask.get();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(result);
        assertNotEquals("", result);
    }

}
