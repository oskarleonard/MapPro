package com.assig.sample.mappro;

import models.BundlePath;

/**
 * Created by Alter on 2015-11-28.
 * A simple interface which helps to commmuicate between StartPage and JsonPresenter
 */
public interface IJsonView {
    void updateView(BundlePath bp);
}
