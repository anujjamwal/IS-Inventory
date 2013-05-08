package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.AssetType;
import com.thoughtworks.is.repositories.AssetTypeRepository;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.AssertJUnit.assertEquals;


public class AssetTypeControllerTest {
    private AssetTypeController assetTypeController;
    private AssetType assetType;

    @Mock
    private AssetTypeRepository mockAssetTypeRepository;

    @Mock
    private BindingResult mockBindingResult;

    @BeforeMethod
    public void setUp(){
        initMocks(this);
        assetTypeController = new AssetTypeController(mockAssetTypeRepository);
        assetType = new AssetType(1l,"Laptop");
    }

    @Test
    public void shouldCreateType(){
        when(mockAssetTypeRepository.saveType(assetType)).thenReturn(assetType);

        ModelAndView result = assetTypeController.createType(assetType, mockBindingResult);

        assertEquals("redirect:/types", result.getViewName());
        verify(mockAssetTypeRepository).saveType(assetType);
    }

    @Test
    public void shouldGetAssetType(){
        List myList = Arrays.asList(assetType.getType());
        when(mockAssetTypeRepository.getTypes()).thenReturn(myList);

        ModelAndView result = assetTypeController.getAssetTypes();

        assertEquals("assets/types", result.getViewName());
        assertEquals(myList, result.getModelMap().get("TYPES"));
        verify(mockAssetTypeRepository).getTypes();
    }
}