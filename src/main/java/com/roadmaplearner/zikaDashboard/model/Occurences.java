package com.roadmaplearner.zikaDashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Occurences {
    @Id
    private Long id;
//    private String higherClassification;
    private String kingdom;
    private String phylum;
    @Column(name = "class")
    private String phylumClass;
    private String family;
    private String scientificName;
    private String genus;

    private String country;
    @Column(name = "state_province")
    private String state_province;
    private String decimalLatitude;
    private String decimalLongitude;
}
