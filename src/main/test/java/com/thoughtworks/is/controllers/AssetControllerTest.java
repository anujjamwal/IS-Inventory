package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import com.thoughtworks.is.repositories.AssetRepository;
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

public class AssetControllerTest  {
    private AssetController assetController;
    private AssetType assetType, assetType1;
    private Asset asset;

    @Mock
    private AssetRepository mockAssetRepository;

    @Mock
    private AssetTypeRepository mockAssetTypeRepository;

    @Mock
    private BindingResult mockBindingResult;

    @BeforeMethod
    public void setUp(){
        initMocks(this);
        assetController = new AssetController(mockAssetRepository, mockAssetTypeRepository);
        asset = new Asset(1l, "Laptop", "Apple", "Mac Air", "12345678900987654321",
                "10 yrs", "TW/IND/GGN/LT/1", "8 GB RAM, 500 GB HD");
        assetType = new AssetType(1l,"Laptop");
        assetType1 = new AssetType(2l,"Keyboard");
    }

    @Test
    public void shouldAddAsset() {
        List myList = Arrays.asList(assetType.getType(),assetType1.getType());
        when (mockAssetTypeRepository.getTypes()).thenReturn(myList);
        when(mockAssetRepository.getLastAsset(assetType.getType())).thenReturn(asset);

        ModelAndView result = assetController.addAsset();

        assertEquals(myList, result.getModelMap().get("TYPES"));
        assertEquals(asset, result.getModelMap().get("ASSET"));
        assertEquals("assets/new", result.getViewName());

    }

    @Test
    public void shouldLoadAsset(){
        Asset asset1;
        when(mockAssetRepository.getLastAsset(assetType.getType())).thenReturn(asset);

        asset1 = assetController.loadAsset(assetType.getType());

        assertEquals(asset1, asset);
        verify(mockAssetRepository).getLastAsset(assetType.getType());
    }

    @Test
    public void shouldCreateAsset() {
        when(mockAssetRepository.save(asset)).thenReturn(asset);

        ModelAndView result = assetController.createAsset(asset, mockBindingResult);

        assertEquals("redirect:/show", result.getViewName());
        verify(mockAssetRepository).save(asset);
    }

    @Test
    public void shouldShowAsset(){
        Asset asset1 = new Asset(2l, "Monitor", "Apple", "Mac Air", "12345678900987654321",
                "10 yrs", "TW/IND/GGN/LT/1", "8 GB RAM, 500 GB HD");
        List myList = Arrays.asList(asset, asset1);
        when(mockAssetRepository.getAll()).thenReturn(myList);

        ModelAndView result = assetController.showAsset();

        verify(mockAssetRepository).getAll();
        assertEquals(myList, result.getModelMap().get("ASSETS"));
    }

}