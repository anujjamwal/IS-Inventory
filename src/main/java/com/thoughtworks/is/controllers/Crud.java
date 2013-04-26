package com.thoughtworks.is.controllers;

import java.util.List;
import com.thoughtworks.is.entities.Asset;
import com.thoughtworks.is.entities.AssetType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class Crud {

    public Asset getById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Asset asset = (Asset) session.get(Asset.class, id);
        session.close();
        return asset;
    }

    public Asset save(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(asset);
        asset.setId(id);
        session.getTransaction().commit();
        session.close();
        return asset;
    }

    public Asset update(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.merge(asset);
        session.getTransaction().commit();
        session.close();
        return asset;

    }

    public void delete(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(asset);
        session.getTransaction().commit();
        session.close();
    }

    public List getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List assets = session.createQuery("from Asset").list();
        session.close();
        return assets;
    }

    public List getTypes() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List types = session.createQuery("SELECT type from AssetType").list();
        session.close();
        return types;
    }

    public AssetType saveType(AssetType asset_type) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(asset_type);
        asset_type.setId(id);
        session.getTransaction().commit();
        session.close();
        return asset_type;
    }

    public Asset getLastAsset(String type) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Asset A WHERE A.type = :type ORDER BY A.id DESC LIMIT 1");
        query.setParameter("type", type);
        List assets = query.list();
        Asset asset;
        if (!assets.isEmpty()) {
            asset = (Asset) assets.get(0);
        } else {
            asset = null;
        }
        session.close();
        return asset;
    }
}


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

