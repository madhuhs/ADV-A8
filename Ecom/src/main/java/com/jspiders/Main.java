package com.jspiders;

import com.jspiders.data.entities.CategoryEntity;
import com.jspiders.data.entities.ProductEntity;
import com.jspiders.data.util.HibernateUtils;
import com.jspiders.services.OrderService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");
////        OrderService orderService = new OrderService();
////        orderService.createOrder();
////        //orderService.findOrderById(1);
////        orderService.disconnect();
//
//        Session session = HibernateUtils.getSession();
//        Transaction transaction = session.beginTransaction();
//
//        ProductEntity product1 = new ProductEntity();
//        product1.setName("iphone");
//        product1.setPrice(100000);
//        product1.setRating(3.6);
//
//        ProductEntity product2 = new ProductEntity();
//        product2.setName("samsung");
//        product2.setPrice(123451);
//        product2.setRating(4.6);
//
//        CategoryEntity category1 = new CategoryEntity();
//        category1.setName("Electronics");
//
//        CategoryEntity category2 = new CategoryEntity();
//        category2.setName("Mobiles");
//
//        //link category to product
//        product1.addCategory(category1);
//        product1.addCategory(category2);
//
//        product2.addCategory(category1);
//        product2.addCategory(category2);
//
//        //link product to category
//        category1.addProduct(product1);
//        category1.addProduct(product2);
//
//        category2.addProduct(product1);
//        category2.addProduct(product2);
//
//        session.persist(product1);
//        session.persist(product2);
//        session.persist(category1);
//        session.persist(category2);
//
//        transaction.commit();
//        HibernateUtils.shutdown();

        OrderService orderService = new OrderService();
        //orderService.createOrder();
        orderService.findOrderById(6);
        orderService.disconnect();
        System.out.println("Program ends...");
    }
}