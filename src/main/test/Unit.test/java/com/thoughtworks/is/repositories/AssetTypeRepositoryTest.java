package com.thoughtworks.is.repositories;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;

public class AssetTypeRepositoryTest {

    private Asset asset;
    private Date utilDate;

    private AssetTypeRepository assetTypeRepository;

    @Mock
    private Session mockSession;

    @Mock
    private SessionFactory mockSessionFactory;

    @BeforeMethod
    public void setup(){
        initMocks(this);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        utilDate = cal.getTime();
        asset = new Asset(1l, "Laptop", "Apple", "Mac Air", "12345678900987654321", utilDate,
                "10 yrs", "TW/IND/GGN/LT/1", "8 GB RAM, 500 GB HD", Boolean.FALSE);
        assetTypeRepository = new AssetTypeRepository(mockSessionFactory, mockSession);
    }

    @Test
    public void shouldSaveAssetType(){
        Transaction mockTransaction = mock(Transaction.class);
        when(mockSession.getTransaction()).thenReturn(mockTransaction);
        AssetType assetType = new AssetType(1l, "Printer");

        AssetType assetType1 = assetTypeRepository.saveType(assetType);

        InOrder inOrder = inOrder(mockSession, mockSession, mockTransaction);
        inOrder.verify(mockSession).beginTransaction();
        inOrder.verify(mockSession).save(assetType);
        inOrder.verify(mockTransaction).commit();
        assertEquals(assetType, assetType1);
    }

    @Test
    public void shouldGetAssetTypes(){
        List myList = Arrays.asList("a", "b", "c");
        Query mockQuery = mock(Query.class);
        when(mockSession.createQuery("SELECT type from AssetType")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(myList);

        List all = assetTypeRepository.getTypes();

        verify(mockSession).createQuery("SELECT type from AssetType");
        assertEquals(myList, all);
    }
}
