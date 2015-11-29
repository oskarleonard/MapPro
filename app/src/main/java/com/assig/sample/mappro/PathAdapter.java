package com.assig.sample.mappro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import models.Path;

/**
 * Created by Alter on 2015-11-29.
 * This adapter uses the path_adapter layout and modifies the views (done in method getView / see last method)
 * in that layout with data. This data comes from a Path in the List<Path> paths.
 */
public class PathAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Context context;
    private List<Path> paths;

    public PathAdapter(Context context, List<Path> path){
        this.context = context;
        this.paths = path;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public Path getItem(int position) {
        return paths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the current item
        Path currentPath = getItem(position);
        convertView = inflater.inflate(R.layout.path_adapter, parent, false);

        //Modify the views with daya
        TextView tvPathName = (TextView)convertView.findViewById(R.id.tvPathName);
        TextView tvLength = (TextView)convertView.findViewById(R.id.tvLength);
        TextView tvTime = (TextView)convertView.findViewById(R.id.tvTime);
        TextView tvNrOfPlaces = (TextView)convertView.findViewById(R.id.tvNrOfPlaces);
        ImageView ivPath = (ImageView)convertView.findViewById(R.id.ivPath);


        //Handle ImageView recycling with Picasso. If Picasso fail just wrap it in an asynchtast like in this stackoverflow answer:
        //      http://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
        String imageUrl = currentPath.getPath_image();
        if (!imageUrl.isEmpty()) {
            Picasso.with(context).load(currentPath.getPath_image()).into(ivPath);
        }

        tvLength.setText(String.valueOf(currentPath.getPath_length()));
        tvTime.setText(String.valueOf(currentPath.getPath_time()));
        tvNrOfPlaces.setText(String.valueOf(currentPath.getPlaces().size()));

        tvPathName.setText(currentPath.getPath_name());
        return convertView;
    }
}
