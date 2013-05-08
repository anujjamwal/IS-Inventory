package com.thoughtworks.is.repositories;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.repositories.AssetRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class AssetRepositoryTest {

    private Asset asset;

    @Mock
    private Session mockSession;

    @Mock
    private SessionFactory mockSessionFactory;

    private AssetRepository assetRepository;

    @BeforeMethod
    public void setup(){
        initMocks(this);
        asset = new Asset(1l, "Laptop", "Apple", "Mac Air", "12345678900987654321",
                          "10 yrs", "TW/IND/GGN/LT/1", "8 GB RAM, 500 GB HD");
        assetRepository = new AssetRepository(mockSessionFactory, mockSession);
    }

    @Test
    public void shouldSaveTheAsset() {
        Transaction mockTransaction = mock(Transaction.class);
        when(mockSession.getTransaction()).thenReturn(mockTransaction);

        Asset asset1 = assetRepository.save(asset);

        InOrder inOrder = inOrder(mockSession, mockSession, mockTransaction);
        inOrder.verify(mockSession).beginTransaction();
        inOrder.verify(mockSession).save(asset);
        inOrder.verify(mockTransaction).commit();
        assertEquals(asset, asset1);
    }

    @Test
    public void shouldGetAllAssets(){
        List myList = Arrays.asList("a", "b", "c");
        Query mockQuery = mock(Query.class);
        when(mockSession.createQuery("from Asset")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(myList);

        List all = assetRepository.getAll();

        verify(mockSession).createQuery("from Asset");
        assertEquals(myList, all);
    }

    @Test
    public void shouldGetLastAsset(){
        Asset asset1 = new Asset(2l, "Monitor", "Apple", "Mac Air", "12345678900987654321",
                "10 yrs", "TW/IND/GGN/LT/1", "8 GB RAM, 500 GB HD");
        List myList = Arrays.asList(asset, asset1);
        Query mockQuery = mock(Query.class);
        when(mockSession.createQuery(anyString())).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(myList);

        Asset asset2 = assetRepository.getLastAsset("Laptop");

        verify(mockSession).createQuery("from Asset A WHERE A.type = :type ORDER BY A.id DESC LIMIT 1");
        assertEquals(asset, asset2);
    }

    @Test
    public void shouldReturnNullAsset(){
        List myList = new ArrayList();
        Query mockQuery = mock(Query.class);
        when(mockSession.createQuery("from Asset A WHERE A.type = :type ORDER BY A.id DESC LIMIT 1")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(myList);

        Asset asset1 = assetRepository.getLastAsset("Printer");

        verify(mockSession).createQuery("from Asset A WHERE A.type = :type ORDER BY A.id DESC LIMIT 1");
        assertNull(asset1);
    }

}