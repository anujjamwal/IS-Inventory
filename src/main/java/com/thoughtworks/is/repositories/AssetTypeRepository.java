package com.thoughtworks.is.repositories;

import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import com.thoughtworks.is.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class AssetTypeRepository {

    private SessionFactory sf;
    private Session session;

    public AssetTypeRepository() {
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public AssetType saveType(AssetType asset_type) {
        session.beginTransaction();
        session.save(asset_type);
        session.getTransaction().commit();
        return asset_type;
    }

    public List getTypes() {
        List types = session.createQuery("SELECT type from AssetType").list();
        return types;
    }
}
