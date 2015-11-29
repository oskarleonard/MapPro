package com.assig.sample.mappro;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Path;
import models.Place;
import util.MyDebugger;

/**
 * This activity shows the chosen Path in a googlemap
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Path currentPath;

    //Associate marker with place
    private Map<Marker, Place> markerPlaceMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get the clicked path
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentPath = new Gson().fromJson(extras.getString(StartPage.BUNDLE_PATH), Path.class);
            if (MyDebugger.ON) {
                if (currentPath != null) {
                    Log.v("MapsActivity", "currentPath is not null");
                } else {
                    Log.v("MapsActivity", "currentPath is null");
                }
            }
        }


    }

    /**
     * This is where everything happens
     *
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // First lat & lng defines the startlocation in googlemap
        LatLng startLocation = new LatLng(
                Double.parseDouble(currentPath.getPath_polyline().get(0).get(0).get("lat")),
                Double.parseDouble(currentPath.getPath_polyline().get(0).get(0).get("lng")));

        //Add path to map
        mMap.addPolyline(getPolilineOptons());
        //AddPlaces to map
        addPlacesOnPath();

        //Open clicked place in a DialogFragment
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Place place = markerPlaceMap.get(marker);
                DialogFragment placeDialog = PlaceDialogFragment.newInstance(place);
                placeDialog.show(getSupportFragmentManager().beginTransaction(), "DIAL");
                return true;
            }
        });

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 16));
    }

    /**
     * It the path has places, add them to the map.
     */
    private void addPlacesOnPath() {

        for (Place place : currentPath.getPlaces()) {
            MarkerOptions marker = new MarkerOptions();
            marker.position(mapToLatLng(place.getPlace_position()));
            marker.title(place.getPlace_name());
            Marker m = mMap.addMarker(marker);
            markerPlaceMap.put(m, place);
        }

    }

    /**
     * Create a path with PolylineOptions
     *
     * @return specified polilineoption
     */
    private PolylineOptions getPolilineOptons() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(6);
        polylineOptions.addAll(convertToLatLngList(currentPath.getPath_polyline()));
        return polylineOptions;
    }


    /**
     * Convert Path field path_polyline (List<List<Map<String, Double>>>) to a list
     * that can be easily used by googlemap.
     *
     * @param pathList
     * @return
     */
    private List<LatLng> convertToLatLngList(List<List<Map<String, String>>> pathList) {
        List<LatLng> toReturn = new ArrayList<>();

        List<Map<String, String>> mapLatLng = pathList.get(0);

        for (Map<String, String> map : mapLatLng) {
            toReturn.add(mapToLatLng(map));
        }
        return toReturn;
    }

    /**
     * Convert Map to google LatLng
     *
     * @param map
     * @return
     */
    private LatLng mapToLatLng(Map<String, String> map) {
        LatLng latLng = new LatLng(Double.parseDouble(map.get("lat")), Double.parseDouble(map.get("lng")));
        return latLng;
    }

}
