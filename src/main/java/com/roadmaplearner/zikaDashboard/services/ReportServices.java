package com.roadmaplearner.zikaDashboard.services;

import com.roadmaplearner.zikaDashboard.features.Feature;
import com.roadmaplearner.zikaDashboard.features.FeatureCollection;
import com.roadmaplearner.zikaDashboard.features.WktHelper;
import com.roadmaplearner.zikaDashboard.model.Report;
import com.roadmaplearner.zikaDashboard.repository.ReportRepository;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.InStream;
import com.vividsolutions.jts.io.WKBReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServices {
    @Autowired
    ReportRepository reportRepository;
//    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public FeatureCollection getAllReports() throws Exception {
        List<Report> reports;
        reports = reportRepository.findAll();
        if(reports.isEmpty()) return new FeatureCollection();
        FeatureCollection featureCollection = new FeatureCollection();
        for(Report report: reports){
            Map<String, Object> properties = new HashMap<>();
            properties.put("reportedDate", report.getReportedDate());
            properties.put("location", report.getLocation());
            properties.put("locationType", report.getLocationType());
            properties.put("dataField", report.getDataField());
            properties.put("dataFieldCode", report.getDataFieldCode());
            properties.put("timePeriod", report.getTimePeriod());
            properties.put("timePeriodType", report.getTimePeriodType());
            properties.put("value", report.getValue());
            properties.put("unit", report.getUnit());
            Geometry geometry = WktHelper.wktToGeometry(report.getLocationGeometry());
            featureCollection.addFeature(new Feature(geometry, properties));
        }
        return featureCollection;
    }
}
