package com.thoughtworks.is.services;

import org.springframework.stereotype.Service;

public class Asset {

    private String type;
    private String brand;
    private String model;
    private String serialNo;
    private String warranty;
    private String assetTag;
    private String description;


    public String getType()
    {
        return type;

    }
    public void setType(String type)
    {
        this.type=type;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand=brand;
    }
    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model=model;
    }
    public String getSerialNo()
    {
        return serialNo;
    }
    public void setSerialNo(String serialNo)
    {
        this.serialNo=serialNo;
    }
    public String getWarranty()
    {
        return warranty;
    }
    public void setWarranty(String warranty)
    {
        this.warranty=warranty;
    }
    public String getAssetTag()
    {
        return assetTag;
    }
    public void setAsset_tag(String assetTag)
    {
        this.assetTag=assetTag;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }

}