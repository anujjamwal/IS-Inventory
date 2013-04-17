package com.thoughtworks.services;

import org.springframework.stereotype.Service;

public class Asset {

     private String asset_type;
     private String brand;
     private String model;
     private String serial_no;
     private String warranty;
     private String asset_tag;
     private String description;

     public String getAssetType()
     {
        return asset_type;

     }
     public void setAssetType(String asset_type)
     {
        this.asset_type=asset_type;
     }


}
