package com.assig.sample.mappro;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import models.Path;
import models.Place;
import util.MyDebugger;

/**
 * Created by Alter on 2015-11-29.
 * This is the dialog that will be shown when the user clicks on a place(marker) on the map
 */
public class PlaceDialogFragment extends DialogFragment {

    private View theView;
    private Place place;


    public static PlaceDialogFragment newInstance(Place place) {
        PlaceDialogFragment f = new PlaceDialogFragment();

        Bundle args = new Bundle();
        Gson gson = new Gson();
        args.putString("PLACE", gson.toJson(place));
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.fragment_place_dialog, container, false);

        //Disable screen rotation on dialog
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (getArguments() != null) {
            Gson gson = new Gson();
            place = gson.fromJson(getArguments().getString("PLACE"), Place.class);
        }else{
            //Just load a default place for now. TODO fix;
            place = new Place();
        }

        setUpViews();

        return theView;
    }


    private void setUpViews() {
        Button btnCancel = (Button)theView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ImageView ivPlaceImage = (ImageView)theView.findViewById(R.id.ivPlaceImage);
        TextView tvPlaceName = (TextView)theView.findViewById(R.id.tvPlaceName);
        TextView tvPlaceDescription = (TextView)theView.findViewById(R.id.tvPlaceDescription);

        //Load Image
        String imageUrl = place.getPlace_image();
        if (!imageUrl.isEmpty()) {
            Picasso.with(getContext()).load(imageUrl).into(ivPlaceImage);
        }

        tvPlaceName.setText(place.getPlace_name());
        tvPlaceDescription.setText(place.getPlace_info());

    }


}
