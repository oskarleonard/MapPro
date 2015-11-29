package models;

import java.util.List;
import java.util.Map;

/**
 * Created by Alter on 2015-11-28.
 * A place model that will be mapped to JSON data
 */
public class Place {
    private String place_image;
    private double place_radius;
    private Map<String, String> place_position;
    private String place_info;
    private List<PlaceMedia> place_media;
    private String place_name;


    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }

    public double getPlace_radius() {
        return place_radius;
    }

    public void setPlace_radius(double place_radius) {
        this.place_radius = place_radius;
    }

    public Map<String, String> getPlace_position() {
        return place_position;
    }
    public void setPlace_position(Map<String, String> place_position) {
        this.place_position = place_position;
    }

    public String getPlace_info() {
        return place_info;
    }

    public void setPlace_info(String place_info) {
        this.place_info = place_info;
    }

    public List<PlaceMedia> getPlace_media() {
        return place_media;
    }

    public void setPlace_media(List<PlaceMedia> place_media) {
        this.place_media = place_media;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }
}
