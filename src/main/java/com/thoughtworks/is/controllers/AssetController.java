package com.thoughtworks.is.controllers;

import com.thoughtworks.is.services.Asset;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AssetController {

    @RequestMapping("/")
    public String addAssetType(Model model){
        return "new";
    }

    @RequestMapping(value="/new",method = RequestMethod.POST)
    public String createAsset(Model model,@ModelAttribute("asset")Asset asset, BindingResult result)
    {
        model.addAttribute("assetType",asset.getType());
        model.addAttribute("model",asset.getModel());
        model.addAttribute("serialNo",asset.getSerialNo());
        model.addAttribute("assetTag",asset.getAssetTag());
        model.addAttribute("brand",asset.getBrand());
        model.addAttribute("description",asset.getDescription());
        model.addAttribute("warranty",asset.getWarranty());
        return "view";
    }



}
