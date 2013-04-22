package com.thoughtworks.is.controllers;

import java.sql.Date;
import java.util.List;

import com.thoughtworks.is.services.Asset;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
* Created with IntelliJ IDEA.
* User: pulkitko
* Date: 4/18/13
* Time: 12:11 PM
* To change this template use File | Settings | File Templates.
*/
public class Main {


    public static void main(String[] args) {


        // Read
        System.out.println("******* READ *******");
        List assets = getAll();
        System.out.println("Total Assets: " + assets.size());


        // Write
        System.out.println("******* WRITE *******");
        Asset asset = new Asset(1l, "Laptop", "Apple", "Air", "1234567890", "4 yrs", "TW/IND/GGN/LT/1", "4GB");
        asset = save(asset);
        asset = getById(asset.getId());
        System.out.printf("%d %s %s \n", asset.getId(), asset.getModel(), asset.getBrand());



        // Update
        System.out.println("******* UPDATE *******");
        Asset asset1 = getById(1l); // read Asset with id 1
        System.out.println("Name Before Update:" + asset1.getBrand());
        asset1.setBrand("Dell");
        update(asset1);  // save the updated asset details

        asset1 = getById(1l); // read again asset with id 1
        System.out.println("Name Aftere Update:" + asset1.getBrand());


        // Delete
        System.out.println("******* DELETE *******");
        delete(asset);
        Asset asset2 = getById(asset1.getId());
        System.out.println("Object:" + asset2);
    }



    private static List getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List assets = session.createQuery("from ASSET").list();
        session.close();
        return assets;
    }
    private static Asset getById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Asset asset = (Asset) session.get(Asset.class, id);
        session.close();
        return asset;
    }
    private static Asset save(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session   = sf.openSession();

        session.beginTransaction();

        Long id = (Long) session.save(asset);
        asset.setId(id);

        session.getTransaction().commit();

        session.close();

        return asset;
    }

    private static Asset update(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(asset);

        session.getTransaction().commit();

        session.close();
        return asset;

    }

    private static void delete(Asset asset) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(asset);

        session.getTransaction().commit();

        session.close();
    }
}
