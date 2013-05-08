package com.thoughtworks.is.repositories;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssignedAsset;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;


public class AssignedAssetRepositoryTest {


    private AssignedAsset assignedAsset;

    @Mock
    private Session mockSession;

    @Mock
    private SessionFactory mockSessionFactory;

    private AssignedAssetRepository assignedAssetRepository;

    @BeforeMethod
    public void setup() {
        initMocks(this);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        assignedAsset = new AssignedAsset(null, "TW/IND/GGN/LT/1", "appu", "Office", utilDate, null);
        assignedAssetRepository = new AssignedAssetRepository(mockSessionFactory, mockSession);
    }

    @Test
    public void shouldSaveTheAssignedAsset() {
        Transaction mockTransaction = mock(Transaction.class);
        when(mockSession.getTransaction()).thenReturn(mockTransaction);
        Query mockQuery = mock(Query.class);
        when(mockSession.createQuery(anyString())).thenReturn(mockQuery);

        AssignedAsset assignedAsset1 = assignedAssetRepository.saveAssignedAsset(assignedAsset);

        InOrder inOrder = inOrder(mockSession, mockSession, mockTransaction);
        inOrder.verify(mockSession).beginTransaction();
        inOrder.verify(mockSession).save(assignedAsset);
        inOrder.verify(mockTransaction).commit();
        assertEquals(assignedAsset, assignedAsset1);
        System.out.println(assignedAsset);
    }
}
