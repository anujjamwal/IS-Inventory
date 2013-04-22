package com.thoughtworks.is.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "ASSET")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Asset {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "serialNo")
    private String serialNo;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "assetTag")
    private String assetTag;

    @Column(name = "description")
    private String description;


}

