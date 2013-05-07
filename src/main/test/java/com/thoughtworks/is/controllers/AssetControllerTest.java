package com.thoughtworks.is.controllers;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import com.thoughtworks.is.repositories.AssetRepository;
import com.thoughtworks.is.repositories.AssetTypeRepository;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.AssertJUnit.assertEquals;

public class AssetControllerTest  {

    private AssetController assetController;
    private Asset asset;
    private AssetType assetType;
    private AssetType assetType1;

    @Mock
    private AssetRepository mockAssetRepository;

    @Mock
    private AssetTypeRepository mockAssetTypeRepository;


    @BeforeMethod
    public void setup()
    {
      initMocks(this);
      assetController =new AssetController(mockAssetRepository, mockAssetTypeRepository);
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
}