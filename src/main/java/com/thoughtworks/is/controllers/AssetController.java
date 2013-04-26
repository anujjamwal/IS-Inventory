package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AssetController {
    @Autowired
    private Crud crud;

    @RequestMapping("/")
    public ModelAndView addAsset() {
        ModelAndView mav = new ModelAndView("assets/new");
        List types = crud.getTypes();
        mav.addObject("TYPES", types);
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView createAsset(@ModelAttribute("asset") Asset asset, BindingResult result) {
          ModelAndView mav = new ModelAndView("redirect:/show");
//        mav.addObject("assetType", asset.getType());
//        mav.addObject("model", asset.getModel());
//        mav.addObject("serialNo", asset.getSerialNo());
//        mav.addObject("assetTag", asset.getAssetTag());
//        mav.addObject("brand", asset.getBrand());
//        mav.addObject("description", asset.getDescription());
//        mav.addObject("warranty", asset.getWarranty());
        crud.save(asset);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView showAsset() {
        ModelAndView mav = new ModelAndView("assets/show");
        List assets = crud.getAll();
        mav.addObject("ASSETS", assets);
        return mav;
    }

    @RequestMapping(value="/create_type",method = RequestMethod.POST)
    public ModelAndView createType(@ModelAttribute("asset_type")AssetType asset_type, BindingResult result)
    {   ModelAndView mav = new ModelAndView("redirect:/types");
        crud.saveType(asset_type);
        return mav;
    }

    @RequestMapping("/types")
    public ModelAndView assetTypes() {
        ModelAndView mav = new ModelAndView("assets/types");
        List types = crud.getTypes();
        mav.addObject("TYPES", types);
        return mav;
    }
}
