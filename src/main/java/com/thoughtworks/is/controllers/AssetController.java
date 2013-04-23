package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.Asset;
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
    private Main main;

    @RequestMapping("/")
    public String addAsset(){
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
        main.save(asset);
        return "redirect:/show";
    }

   @RequestMapping("/show")
    public ModelAndView showAsset()
   {
        ModelAndView mav = new ModelAndView("show");
        List assets = main.getAll();
        mav.addObject("ASSETS", assets);
        return mav;
   }

}
