package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.AssignedAsset;
import com.thoughtworks.is.repositories.AssignedAssetRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class AssignedAssetController {


    @Autowired
    private AssignedAssetRepository assignedAssetRepository;

    @RequestMapping(value = "/assigned_assets", method = POST)
    public ModelAndView assignAsset(@ModelAttribute("assignedAsset") AssignedAsset assignedAsset, BindingResult result) {
        ModelAndView mav = new ModelAndView("redirect:/assigned");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        assignedAsset.setAssignedDate(utilDate);
        assignedAssetRepository.saveAssignedAsset(assignedAsset);
        return mav;
    }

    @RequestMapping("/assigned")
    public ModelAndView showAssignedAssets() {
        ModelAndView mav = new ModelAndView("assets/assigned");
        List assigned_assets = assignedAssetRepository.getAssignedAssets();
        mav.addObject("ASSIGNED_ASSETS", assigned_assets);
        return mav;
    }
}
