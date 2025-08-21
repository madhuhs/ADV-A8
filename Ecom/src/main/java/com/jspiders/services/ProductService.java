package com.jspiders.services;

import com.jspiders.data.entities.ProductEntity;
import com.jspiders.data.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService {

    public void findProductByName(String name){
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();

        String findProductByNameHql = "FROM ProductEntity p where p.name = :name";

        Query<ProductEntity> query = session.createQuery(findProductByNameHql, ProductEntity.class);
        query.setParameter("name",name);
        List<ProductEntity> productEntityList =  query.getResultList();
        productEntityList.forEach(product -> {
            System.out.println(product);
        });

        tx.commit();
        HibernateUtils.shutdown();
    }
    public void findProductByAbovePrice(double price){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String findProductByAbovePriceHql = "FROM ProductEntity p where p.price > :price";

        Query<ProductEntity> query = session.createQuery(findProductByAbovePriceHql, ProductEntity.class);
        query.setParameter("price",price);
        List<ProductEntity> resultList = query.getResultList();

        for (ProductEntity productEntity : resultList) {
            System.out.println(productEntity);
        }

        transaction.commit();
        HibernateUtils.shutdown();
    }
}








