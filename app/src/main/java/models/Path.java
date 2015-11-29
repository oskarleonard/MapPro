package models;

import java.util.List;
import java.util.Map;

/**
 * Created by Alter on 2015-11-28.
 *
 * A model of the Path JSON data.
 * Retrived from:
 *  https://forward-byte-711.appspot.com/read/Test/Development/en
 *
 *  NOTE: Since all variable names matches the input name in the Json String you do not need to provide the annotation (@SerializedName("path_name"))
 *
 */

public class Path {
    private String path_name;
    private List<Place> places;
    private double path_length;
    private String path_time;
    private String path_image;
    private String path_info;
    private List<List<Map<String, String>>> path_polyline;


    /*Getter Setters*/
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public double getPath_length() {
        return path_length;
    }

    public void setPath_length(double path_length) {
        this.path_length = path_length;
    }

    public String getPath_time() {
        return path_time;
    }

    public void setPath_time(String path_time) {
        this.path_time = path_time;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public String getPath_info() {
        return path_info;
    }

    public void setPath_info(String path_info) {
        this.path_info = path_info;
    }

    public List<List<Map<String, String>>> getPath_polyline() {
        return path_polyline;
    }

    public void setPath_polyline(List<List<Map<String, String>>> path_polyline) {
        this.path_polyline = path_polyline;
    }

}
