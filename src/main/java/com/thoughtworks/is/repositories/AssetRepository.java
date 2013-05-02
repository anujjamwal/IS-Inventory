package com.thoughtworks.is.repositories;

import java.util.List;

import com.thoughtworks.is.utils.HibernateUtil;
import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.ObjectUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AssetRepository {
    private SessionFactory sf;
    private Session session;

    public AssetRepository() {
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
    }

    public Asset save(Asset asset) {
        session.beginTransaction();
        session.save(asset);
        session.getTransaction().commit();
        return asset;
    }

    public List getAll() {
        List assets = session.createQuery("from Asset").list();
        return assets;
    }

    public Asset getLastAsset(String type) {
        Query query = session.createQuery("from Asset A WHERE A.type = :type ORDER BY A.id DESC LIMIT 1");
        query.setParameter("type", type);
        List<Asset> assets = query.list();

        if (assets.isEmpty()) return null;

        return assets.get(0);
    }
}
































//        public Asset getById(Long id) {
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        Asset asset = (Asset) session.get(Asset.class, id);
//        session.close();
//        return asset;
//    }

//    public Asset update(Asset asset) {
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//        session.merge(asset);
//        session.getTransaction().commit();
//        session.close();
//        return asset;
//
//    }
//
//    public void delete(Asset asset) {
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//        session.delete(asset);
//        session.getTransaction().commit();
//        session.close();
//    }


//
//    public static void main(String[] args) {
//
//
//        // Read
//        System.out.println("******* READ *******");
//        List assets = getAll();
//        System.out.println("Total Assets: " + assets.size());
//
//
//        // Write
//        System.out.println("******* WRITE *******");
//        Asset asset = new Asset(1l, "Laptop", "Apple", "Air", "1234567890", "4 yrs", "TW/IND/GGN/LT/1", "4GB");
//        asset = save(asset);
//        asset = getById(asset.getId());
//        System.out.printf("%d %s %s \n", asset.getId(), asset.getModel(), asset.getBrand());
//
//
//
//        // Update
//        System.out.println("******* UPDATE *******");
//        Asset asset1 = getById(1l); // read Asset with id 1
//        System.out.println("Name Before Update:" + asset1.getBrand());
//        asset1.setBrand("Dell");
//        update(asset1);  // save the updated asset details
//
//        asset1 = getById(1l); // read again asset with id 1
//        System.out.println("Name Aftere Update:" + asset1.getBrand());
//
//
//        // Delete
//        System.out.println("******* DELETE *******");
//        delete(asset);
//        Asset asset2 = getById(asset1.getId());
//        System.out.println("Object:" + asset2);
//    }

