package com.roadmaplearner.zikaDashboard.controllers;

import com.roadmaplearner.zikaDashboard.features.FeatureCollection;
import com.roadmaplearner.zikaDashboard.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/zikaDashboard")
@CrossOrigin
public class ReportController {
    @Autowired
    ReportServices reportServices;

    @GetMapping("/")
//    @PreAuthorize("hasRole('client-zika-user')")
    public FeatureCollection getAllReports() throws Exception {
        return reportServices.getAllReports();
    }
    @GetMapping("/get2")
//    @PreAuthorize("hasRole('client-zika-admin')")
    public FeatureCollection getAllReports2() throws Exception {
        return reportServices.getAllReports();
    }
}
