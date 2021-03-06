package com.thoughtworks.is.repositories;

import com.thoughtworks.is.entities.AssignedAsset;
import com.thoughtworks.is.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AssignedAssetRepository {


    private SessionFactory sf;
    private Session session;

    public AssignedAssetRepository() {
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public AssignedAsset saveAssignedAsset(AssignedAsset assignedAsset) {

        session.beginTransaction();
        Query query = session.createQuery("UPDATE Asset set isAssigned = TRUE WHERE assetTag = :asset_tag");
        query.setParameter("asset_tag", assignedAsset.getAssetTag());
        query.executeUpdate();
        session.save(assignedAsset);
        session.getTransaction().commit();
        return assignedAsset;
    }

    public List getAssignedAssets() {
        List assigned_assets = session.createQuery("from AssignedAsset").list();
        return assigned_assets;
    }
}
