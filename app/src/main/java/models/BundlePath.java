package models;

import java.util.List;

/**
 * Created by Alter on 2015-11-28.
 * A BundlePath Contains the data from the jSon server.
 * TODO: refractor public fields to private with getter and setters.
 */
public class BundlePath {
    public List<Path> paths;
    public String bundle_info;
    public String bundle_more_info;
}
