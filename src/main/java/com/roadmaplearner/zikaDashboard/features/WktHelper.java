package com.roadmaplearner.zikaDashboard.features;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKTReader;

//convert WKB to WKT
public class WktHelper {
    public static String wkbToWkt(byte[] wkb) throws Exception{
        WKBReader reader = new WKBReader();
        Geometry geometry = reader.read(wkb);
        return geometry.toText();
    }
    public static Geometry wktToGeometry(String wktPoint) throws Exception {
//        String wktPoint = wkbToWkt(wkb);
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(wktPoint);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + wktPoint);
        }
        return geom;
    }

}
