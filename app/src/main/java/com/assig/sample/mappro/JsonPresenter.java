package com.assig.sample.mappro;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import models.BundlePath;
import util.HttpManager;
import util.MyDebugger;


/**
 * Created by Alter on 2015-11-28.
 * Class to handle Json Server Requests so it
 */
public class JsonPresenter {

    //List of AsyncTask (related to class MyTask, see below)
    private List<MyTask> tasks;

    private IJsonView view;
    private BundlePath bundlePath;

    public JsonPresenter(IJsonView view) {
        this.view = view;
        tasks = new ArrayList<>();
    }

    public void onRetrieveJson(String url) {
        //String jSon = view.getJson();
        MyTask task = new MyTask();
        task.execute(url);
    }

    /**
     * A class to to do Json retrieval not on the main thread
     * In Android HttpURLConnection should not be done in the main thread
     * So need to create separate thread for HttpManager which will get json data from server
     */
    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            tasks.add(this);
        }

        @Override
        protected String doInBackground(String... params) {

            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String result) {

            Gson gson = new Gson();

            bundlePath = gson.fromJson(result, BundlePath.class);

            if (MyDebugger.ON) {
                Log.v("Resutl", result);
                Log.v("bundlePath", bundlePath.bundle_info);
            }

            tasks.remove(this);
            view.updateView(bundlePath);

        }


    }
}
