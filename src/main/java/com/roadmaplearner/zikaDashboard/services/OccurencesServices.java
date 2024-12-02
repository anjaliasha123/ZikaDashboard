package com.roadmaplearner.zikaDashboard.services;

import com.roadmaplearner.zikaDashboard.features.Feature;
import com.roadmaplearner.zikaDashboard.features.FeatureCollection;
import com.roadmaplearner.zikaDashboard.features.WktHelper;
import com.roadmaplearner.zikaDashboard.model.Occurences;
import com.roadmaplearner.zikaDashboard.repository.OccurencesRepository;
import com.vividsolutions.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OccurencesServices {
    @Autowired
    OccurencesRepository occurencesRepository;

    public FeatureCollection getAllOccurrences() throws Exception {
        List<Occurences> occurencesList;
        occurencesList = occurencesRepository.findAll();
        if(occurencesList.isEmpty()) return new FeatureCollection();
        FeatureCollection featureCollection = new FeatureCollection();
        for(Occurences occurence : occurencesList){
            Map<String, Object> properties = new HashMap<>();
            properties.put("kingdom", occurence.getKingdom());
            properties.put("phylum", occurence.getPhylum());
            properties.put("class", occurence.getPhylumClass());
            properties.put("country", occurence.getCountry());
            properties.put("state", occurence.getState_province());
            properties.put("family", occurence.getFamily());
            properties.put("scientificName", occurence.getScientificName());
            properties.put("genus", occurence.getGenus());
            String latitude = occurence.getDecimalLatitude();
            String longitude = occurence.getDecimalLongitude();
            String point = "POINT("+longitude+" "+latitude+")";
            Geometry geometry = WktHelper.wktToGeometry(point);
            featureCollection.addFeature(new Feature(geometry, properties));
        }
        return featureCollection;
    }
}
