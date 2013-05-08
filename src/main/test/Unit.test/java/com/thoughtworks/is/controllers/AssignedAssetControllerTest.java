package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.AssignedAsset;
import com.thoughtworks.is.repositories.AssignedAssetRepository;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.AssertJUnit.assertEquals;

public class AssignedAssetControllerTest {
    private AssignedAssetController assignedAssetController;
    private AssignedAsset assignedAsset;

    @Mock
    private AssignedAssetRepository mockAssignedAssetRepository;

    @Mock
    private BindingResult mockBindingResult;

    @BeforeMethod
    public void setUp(){
        initMocks(this);
        assignedAssetController = new AssignedAssetController(mockAssignedAssetRepository);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        assignedAsset = new AssignedAsset(null, "TW/IND/GGN/LT/1", "Laptop", "apurvagu", utilDate, null);
    }

    @Test
    public void shouldAssignAsset(){
        when(mockAssignedAssetRepository.saveAssignedAsset(assignedAsset)).thenReturn(assignedAsset);

        ModelAndView result = assignedAssetController.assignAsset(assignedAsset,mockBindingResult);

        assertEquals("redirect:/assigned",result.getViewName());
        verify(mockAssignedAssetRepository).saveAssignedAsset(assignedAsset);
    }

    @Test
    public void shouldShowAssignedAssets(){
        List myList = Arrays.asList(assignedAsset);
        when(mockAssignedAssetRepository.getAssignedAssets()).thenReturn(myList);
        ModelAndView result = assignedAssetController.showAssignedAssets();
        assertEquals("assets/assigned",result.getViewName());
        assertEquals(myList,result.getModelMap().get("ASSIGNED_ASSETS"));
        verify(mockAssignedAssetRepository).getAssignedAssets();
    }

}
