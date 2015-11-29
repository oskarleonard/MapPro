package models;

/**
 * Created by Alter on 2015-11-29.
 * Sonce English version returns different object than swedish i need to make my solution more generic which i will do with this class.
 */
public class MediaContent {
    private String content_text;
    private String content_url;

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }
}
