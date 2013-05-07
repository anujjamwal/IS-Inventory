package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.repositories.AssetRepository;
import com.thoughtworks.is.repositories.AssetTypeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@NoArgsConstructor
@AllArgsConstructor
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetTypeRepository assetTypeRepository;

    @RequestMapping("/")
    public ModelAndView addAsset() {
        ModelAndView mav = new ModelAndView("assets/new");
        List types = assetTypeRepository.getTypes();
        if (!types.isEmpty()) {
            String type = (String) types.get(0);
            Asset asset = assetRepository.getLastAsset(type);
            mav.addObject("ASSET", asset);
        }
        mav.addObject("TYPES", types);
        return mav;
    }

    @RequestMapping(value = "/", method = POST)
    public @ResponseBody Asset loadAsset(@ModelAttribute("type") String type) {
        Asset asset = assetRepository.getLastAsset(type);
        return asset;
    }


    @RequestMapping(value = "/new", method = POST)
    public ModelAndView createAsset(@ModelAttribute("asset") Asset asset, BindingResult result) {
        ModelAndView mav = new ModelAndView("redirect:/show");
        assetRepository.save(asset);
        return mav;
    }

    @RequestMapping("/show")
    public ModelAndView showAsset() {
        ModelAndView mav = new ModelAndView("assets/show");
        List assets = assetRepository.getAll();
        mav.addObject("ASSETS", assets);
        return mav;
    }


}


//@RequestMapping(value = "/", method = POST, headers = "Accept=application/json")
//public ResponseEntity<Asset> loadAsset(@RequestBody String type) {
//        Asset asset = assetRepository.getLastAsset(type);
//return new ResponseEntity<Asset>(HttpStatus.ACCEPTED);
//}
