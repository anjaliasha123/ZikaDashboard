package com.roadmaplearner.zikaDashboard.controllers;

import com.roadmaplearner.zikaDashboard.features.FeatureCollection;
import com.roadmaplearner.zikaDashboard.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zikaDashboard")
public class ReportController {
    @Autowired
    ReportServices reportServices;

    @GetMapping("/")
    public FeatureCollection getAllReports() throws Exception {
        return reportServices.getAllReports();
    }
}
