package com.thoughtworks.services;

import lombok.Data;
import org.springframework.stereotype.Service;

public @Data class Asset {

     private String type;
     private String brand;
     private String model;
     private String serialNo;
     private String warranty;
     private String assetTag;
     private String description;

}

