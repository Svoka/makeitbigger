package com.udacity.gradle.builditbigger;


import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by artemosipov on 22/05/2018.
 */

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private EndpointsAsyncTaskCallback mCallback;

    public void setCallback(EndpointsAsyncTaskCallback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getAJoke().execute().getJoke();
        } catch (IOException e) {
            if (mCallback != null) {
                mCallback.failed();
            }
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mCallback != null) {
            mCallback.gotJoke(result);
        }
    }


    public interface EndpointsAsyncTaskCallback {
        void gotJoke(String joke);
        void failed();
    }
}
