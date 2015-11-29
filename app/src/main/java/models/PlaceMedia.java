package models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Alter on 2015-11-28.
 *  A place model that will be mapped to JSON data
 */
public class PlaceMedia {
    private String media_type;
    private String media_contents;
    private String media_name;
    private String media_image;

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getMedia_contents() {
        return media_contents;
    }

    public void setMedia_contents(String media_contents) {
        this.media_contents = media_contents;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getMedia_image() {
        return media_image;
    }

    public void setMedia_image(String media_image) {
        this.media_image = media_image;
    }
}
