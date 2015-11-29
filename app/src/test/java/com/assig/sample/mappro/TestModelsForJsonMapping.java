package com.assig.sample.mappro;

import com.google.gson.Gson;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import models.BundlePath;
import models.Path;
import models.PlaceMedia;


/**
 * Created by Alter on 2015-11-28.
 * Test if models can be parssed from given jSon. Very oversimplified.
 * TODO Fix oversimplification.
 */
public class TestModelsForJsonMapping {

    private String jsonToTest;
    private BundlePath bp;

    @Before
    public void setUp() throws Exception {
        jsonToTest = "{\"paths\": [{\"path_name\": \"Test trail 1\", \"places\": [{\"place_image\": \"http://www8.tfe.umu.se/personliga/bt/p8ume_radhus_500.jpg\", \"place_radius\": 25, \"place_position\": {\"lat\": 63.825537805635527, \"lng\": 20.265387296676636}, \"place_info\": \"\", \"place_media\": [{\"media_type\": \"text\", \"media_contents\": \"media contents\", \"media_name\": \"\", \"media_image\": \"\"}], \"place_name\": \"\"}, {\"place_image\": \"https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-xaf1/t31.0-8/c0.187.851.315/p851x315/10492967_789556684400140_3481776385337974598_o.jpg\", \"place_radius\": 25, \"place_position\": {\"lat\": 63.825428956712742, \"lng\": 20.265859365463257}, \"place_info\": \"\", \"place_media\": [{\"media_type\": \"text\", \"media_contents\": \"\", \"media_name\": \"\", \"media_image\": \"\"}], \"place_name\": \"\"}], \"path_length\": \"4\", \"path_polyline\": [[{\"lat\": 63.825552003290262, \"lng\": 20.264759659767151}, {\"lat\": 63.825395828696379, \"lng\": 20.264148116111755}, {\"lat\": 63.825362700640881, \"lng\": 20.263268351554871}, {\"lat\": 63.825466817255517, \"lng\": 20.262570977210999}, {\"lat\": 63.825750769702616, \"lng\": 20.262517333030701}, {\"lat\": 63.825888012359052, \"lng\": 20.263128876686096}, {\"lat\": 63.825869082377231, \"lng\": 20.263976454734802}, {\"lat\": 63.825675049330016, \"lng\": 20.264384150505066}, {\"lat\": 63.825552003290262, \"lng\": 20.264759659767151}]], \"path_image\": \"http://upload.wikimedia.org/wikipedia/commons/thumb/5/54/S%C3%B5rve_tuletorn_2013.jpg/1000px-S%C3%B5rve_tuletorn_2013.jpg\", \"path_time\": \"1\", \"path_info\": \"\"}, {\"path_name\": \"Test trail 2\", \"places\": [{\"place_image\": \"\", \"place_radius\": 25, \"place_position\": {\"lat\": -25.197912831386418, \"lng\": 133.20150375366211}, \"place_info\": \"\", \"place_media\": [], \"place_name\": \"\"}, {\"place_image\": \"http://static.auspost.com.au/ap/css/images/auspost.png\", \"place_radius\": 25, \"place_position\": {\"lat\": -25.198941865234325, \"lng\": 133.20197582244873}, \"place_info\": \"\", \"place_media\": [], \"place_name\": \"Austraila post\"}], \"path_length\": \"55\", \"path_polyline\": [[{\"lat\": -25.19659254880791, \"lng\": 133.20128917694092}, {\"lat\": -25.199155437207381, \"lng\": 133.19725513458252}, {\"lat\": -25.202960838649457, \"lng\": 133.2031774520874}, {\"lat\": -25.198339978567628, \"lng\": 133.20605278015137}, {\"lat\": -25.19659254880791, \"lng\": 133.20128917694092}]], \"path_image\": \"http://upload.wikimedia.org/wikipedia/commons/e/ec/COA_Telmar.png\", \"path_time\": \"3\", \"path_info\": \"\"}, {\"path_name\": \"Test trail 3\", \"places\": [], \"path_length\": \"22\", \"path_polyline\": [[{\"lat\": 64.720079209609111, \"lng\": 21.116065979003906}, {\"lat\": 64.721105480398933, \"lng\": 21.128768920898438}, {\"lat\": 64.719639367354873, \"lng\": 21.136665344238281}, {\"lat\": 64.745284879496765, \"lng\": 21.160697937011719}, {\"lat\": 64.743673592081663, \"lng\": 21.224212646484375}, {\"lat\": 64.73986471270581, \"lng\": 21.232109069824219}, {\"lat\": 64.746603134120448, \"lng\": 21.233482360839844}, {\"lat\": 64.748800082280397, \"lng\": 21.230049133300781}, {\"lat\": 64.772808400877082, \"lng\": 21.184730529785156}, {\"lat\": 64.778807146598766, \"lng\": 21.061477661132812}, {\"lat\": 64.760660516602258, \"lng\": 21.008949279785156}, {\"lat\": 64.74513840279181, \"lng\": 21.016845703125}, {\"lat\": 64.719052899894294, \"lng\": 21.09375}, {\"lat\": 64.723304501022909, \"lng\": 21.107139587402344}, {\"lat\": 64.720079209609111, \"lng\": 21.116065979003906}]], \"path_image\": \"http://upload.wikimedia.org/wikipedia/commons/2/26/SverigesDomstolar2010.png\", \"path_time\": \"4\", \"path_info\": \"\"}, {\"path_name\": \"\", \"places\": [], \"path_length\": 0, \"path_polyline\": [], \"path_image\": \"\", \"path_time\": 0, \"path_info\": \"\"}, {\"path_name\": \"\", \"places\": [], \"path_length\": 0, \"path_polyline\": [], \"path_image\": \"\", \"path_time\": 0, \"path_info\": \"\"}, {\"path_name\": \"\", \"places\": [], \"path_length\": 0, \"path_polyline\": [], \"path_image\": \"\", \"path_time\": 0, \"path_info\": \"\"}], \"bundle_info\": \"This is the english start screen\", \"bundle_more_info\": \"This is the english version of read more\"}";
        //String jsonEng = "{\"paths\": [{\"path_name\": \"ghostwalk test\", \"places\": [{\"place_image\": \"http://www8.tfe.umu.se/personliga/bt/p8ume_radhus_500.jpg\", \"place_radius\": 25, \"place_position\": {\"lat\": 63.825537805635527, \"lng\": 20.265387296676636}, \"place_info\": \"\", \"place_media\": [{\"media_type\": \"text\", \"media_contents\": \"<p>Ett hus! Buuuh!</p>\", \"media_name\": \"\", \"media_image\": \"\"}], \"place_name\": \"r\\u00e5dhuset\"}, {\"place_image\": \"https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-xaf1/t31.0-8/c0.187.851.315/p851x315/10492967_789556684400140_3481776385337974598_o.jpg\", \"place_radius\": 25, \"place_position\": {\"lat\": 63.825428956712742, \"lng\": 20.265859365463257}, \"place_info\": \"\", \"place_media\": [{\"media_type\": \"audio\", \"media_contents\": {\"content_text\": \"h\\u00e4r a skall vara ljud\", \"content_url\": \"http://forward-byte-711.storage.googleapis.com/Evil_Laugh_Male_6-Himan-1359990674.mp3\"}, \"media_name\": \"ljud m bild\", \"media_image\": \"http://screenshots.en.sftcdn.net/en/scrn/55000/55380/3d-spooky-halloween-screensaver-13.jpg\"}, {\"media_type\": \"image\", \"media_contents\": [{\"content_text\": \"test\", \"content_url\": \"http://screenshots.en.sftcdn.net/en/scrn/55000/55380/3d-spooky-halloween-screensaver-13.jpg\"}, {\"content_text\": \"tst2\", \"content_url\": \"http://thumbs.dreamstime.com/x/spooky-graveyard-10375084.jpg\"}, {\"content_text\": \"3\", \"content_url\": \"http://screenshots.en.sftcdn.net/en/scrn/55000/55380/3d-spooky-halloween-screensaver-13.jpg\"}], \"media_name\": \"galleri 3\"}, {\"media_type\": \"audio\", \"media_contents\": {\"content_text\": \"tererer\", \"content_url\": \"http://forward-byte-711.storage.googleapis.com/Evil_Laugh_Male_6-Himan-1359990674.mp3\"}, \"media_name\": \"ljud u bild\", \"media_image\": \"\"}, {\"media_type\": \"text\", \"media_contents\": \"<p>texttexttext 33333. raberaber</p>\", \"media_name\": \"test m bild\", \"media_image\": \"http://screenshots.en.sftcdn.net/en/scrn/55000/55380/3d-spooky-halloween-screensaver-13.jpg\"}, {\"media_type\": \"text\", \"media_contents\": \"<p>sex laskar i en kaskask</p>\", \"media_name\": \"text u bild\", \"media_image\": \"\"}, {\"media_type\": \"image\", \"media_contents\": [{\"content_text\": \"test\", \"content_url\": \"http://screenshots.en.sftcdn.net/en/scrn/55000/55380/3d-spooky-halloween-screensaver-13.jpg\"}], \"media_name\": \"galleri 1\"}, {\"media_type\": \"image\", \"media_contents\": [], \"media_name\": \"galleri 0\"}, {\"media_type\": \"image\", \"media_contents\": [{\"content_text\": \"\", \"content_url\": \"\"}, {\"content_text\": \"\", \"content_url\": \"\"}], \"media_name\": \"galleri 0,0\"}, {\"media_type\": \"audio\", \"media_contents\": {\"content_text\": \"\", \"content_url\": \"\"}, \"media_name\": \"tomt ljud\", \"media_image\": \"\"}], \"place_name\": \"dohi\"}, {\"place_image\": \"\", \"place_radius\": 25, \"place_position\": {\"lat\": 63.825556735840216, \"lng\": 20.2630215883255}, \"place_info\": \"\", \"place_media\": [{\"media_type\": \"text\", \"media_contents\": \"<p>ett torg ligger h&#228;r</p>\", \"media_name\": \"\", \"media_image\": \"\"}, {\"media_type\": \"text\", \"media_contents\": \"<p>ett torg</p>\", \"media_name\": \"ett torg\", \"media_image\": \"\"}], \"place_name\": \"ett torg\"}], \"path_length\": \"4\", \"path_polyline\": [[{\"lat\": 63.825552003290262, \"lng\": 20.264759659767151}, {\"lat\": 63.825395828696379, \"lng\": 20.264148116111755}, {\"lat\": 63.825362700640881, \"lng\": 20.263268351554871}, {\"lat\": 63.825466817255517, \"lng\": 20.262570977210999}, {\"lat\": 63.825750769702616, \"lng\": 20.262517333030701}, {\"lat\": 63.825888012359052, \"lng\": 20.263128876686096}, {\"lat\": 63.825869082377231, \"lng\": 20.263976454734802}, {\"lat\": 63.825675049330016, \"lng\": 20.264384150505066}, {\"lat\": 63.825552003290262, \"lng\": 20.264759659767151}]], \"path_image\": \"http://upload.wikimedia.org/wikipedia/commons/thumb/5/54/S%C3%B5rve_tuletorn_2013.jpg/1000px-S%C3%B5rve_tuletorn_2013.jpg\", \"path_time\": \"1\", \"path_info\": \"en sp\\u00f6kvandring i ume\"}, {\"path_name\": \"Testled 2\", \"places\": [{\"place_image\": \"\", \"place_radius\": 25, \"place_position\": {\"lat\": -25.197912831386418, \"lng\": 133.20150375366211}, \"place_info\": \"\", \"place_media\": [], \"place_name\": \"\"}, {\"place_image\": \"http://static.auspost.com.au/ap/css/images/auspost.png\", \"place_radius\": 25";
        Gson gson = new Gson();
        bp = gson.fromJson(jsonToTest, BundlePath.class);
    }

    @Test
    public void checkBundleInfo() throws Exception {
        Assert.assertEquals("This is the english start screen", bp.bundle_info);
    }

    @Test
    public void checkBundlePathMaping() throws Exception {
        boolean bInfo = bp.bundle_info.equals("This is the english start screen");
        boolean bInfoMore = bp.bundle_more_info.equals("This is the english version of read more");
        boolean path = bp.paths.size() == 6;

        boolean ok = bInfo && bInfoMore && path;
        Assert.assertEquals(true, ok);
    }


    @Test
    public void checkPathMaping() throws Exception {
        Path paths = bp.paths.get(0);

        //boolean pathSize = paths.getPath_image();
        boolean bImage = paths.getPath_image().equals("http://upload.wikimedia.org/wikipedia/commons/thumb/5/54/S%C3%B5rve_tuletorn_2013.jpg/1000px-S%C3%B5rve_tuletorn_2013.jpg");
        boolean bInfo = paths.getPath_info().equals("");
        boolean bLenght = paths.getPath_length() == 4.0;
        boolean bName = paths.getPath_name().equals("Test trail 1");
        boolean bPoly = paths.getPath_polyline().size() == 1;
        boolean bTime = paths.getPath_time().equals("1");
        boolean path = paths.getPlaces().size() == 2;

        boolean ok = bInfo && bImage && path && bLenght && bName && bPoly && bTime;
        Assert.assertEquals(true, ok);
    }

    @Test
    public void checkPlaceMedia() throws Exception {
        PlaceMedia media = bp.paths.get(0).getPlaces().get(0).getPlace_media().get(0);

        boolean bName = media.getMedia_name().equals("");
        boolean bConent = media.getMedia_contents().equals("media contents");
        boolean bImage = media.getMedia_image().equals("");
        boolean bType = media.getMedia_type().equals("text");


        boolean ok = bConent && bImage && bType && bName;

        Assert.assertEquals(true, ok);
    }
}

