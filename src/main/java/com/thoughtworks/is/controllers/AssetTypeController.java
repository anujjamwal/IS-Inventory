package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.AssetType;
import com.thoughtworks.is.repositories.AssetTypeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class AssetTypeController {


    @Autowired
    private AssetTypeRepository assetTypeRepository;

    @RequestMapping(value = "/create_type", method = POST)
    public ModelAndView createType(@ModelAttribute("asset_type") AssetType asset_type, BindingResult result) {
        ModelAndView mav = new ModelAndView("redirect:/types");
        assetTypeRepository.saveType(asset_type);
        return mav;
    }

    @RequestMapping("/types")
    public ModelAndView getAssetTypes() {
        ModelAndView mav = new ModelAndView("assets/types");
        List types = assetTypeRepository.getTypes();
        mav.addObject("TYPES", types);
        return mav;
    }

}
