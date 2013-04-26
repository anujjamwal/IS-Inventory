package com.thoughtworks.is.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name = "ASSETS")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Asset {

    @Id
    @GeneratedValue (generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
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

