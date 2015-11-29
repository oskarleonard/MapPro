package com.assig.sample.mappro;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import models.BundlePath;
import models.Path;
import util.HttpManager;
import util.MyDebugger;

/**
 * This activity is the Start Screen of the app.
 * It Retrieved jSOn from sever and parses it to an BundlePath obj with the help of a JsonPresenter obj
 * displays the paths available
 */

public class StartPage extends AppCompatActivity implements IJsonView {
    public static final String BUNDLE_PATH = "BUNDLE_PATH";

    private BundlePath bundlePath;

    private JsonPresenter jsonPresenter;

    //Android Views
    private Button btnBundleInfo;
    private ListView lvPaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        jsonPresenter = new JsonPresenter(this);
        //tasks = new ArrayList<>();
        //Get jSon From server, TODO only once or when user choose to sync
        requestData("https://forward-byte-711.appspot.com/read/Test/Development/en");

        setupAndroidViews();
    }



    private void setupAndroidViews() {
        lvPaths = (ListView)findViewById(R.id.lvPaths);

        btnBundleInfo = (Button)findViewById(R.id.btnBundleInfo);
        btnBundleInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), bundlePath.bundle_more_info, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**Updates the listview with Data from Paths retrieved from the bundlePathObject
        This method is called in class MyTask onPostExecute().*/
    protected void updateDisplay(BundlePath bp) {
        bundlePath = bp;
        List<Path> pathList = bundlePath.paths;
        pathList = trimPaths(pathList);

        lvPaths.setAdapter(new PathAdapter(this, pathList));

        //Open the MapsActivity with the clicked Path
        lvPaths.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (MyDebugger.ON) {
                    Log.i("START PAGE", "You clicked lvPaths.setOnItemClickListener");
                }

                //TODO Implement Parcelable in the classes, Faster, see:
                    //http://prolificinteractive.com/blog/2014/07/18/why-we-love-parcelable/
                Path path = (Path) lvPaths.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra(BUNDLE_PATH, new Gson().toJson(path));
                startActivity(intent);
            }
        });
    }

    /**
     * Removes all paths that doesnt have any Lat and Long.
     * @param pathList
     * @return
     */
    private List<Path> trimPaths(List<Path> pathList){
        List<Path> toReturn = new ArrayList<>();

        for (Path p : pathList) {
            if (!p.getPath_polyline().isEmpty() ) {
                toReturn.add(p);
            }
        }

        return toReturn;
    }

    /**
     * Reguest Json Data from Server in a separate thread
     * @param uri
     */
    private void requestData(String uri) {
        jsonPresenter.onRetrieveJson(uri);
    }


    @Override
    public void updateView(BundlePath bp) {
        updateDisplay(bp);
    }

}
