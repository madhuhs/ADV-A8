package com.jspiders.data.repo;

import com.jspiders.data.entities.OrdersEntity;
import com.jspiders.data.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrdersRepository {
    public void createOrder(OrdersEntity ordersEntity){
       Session session = HibernateUtils.getSession();
       Transaction transaction = session.beginTransaction();
       session.persist(ordersEntity);
       transaction.commit();
       session.close();
    }

    public OrdersEntity findOrderById(long id){
        Session session = HibernateUtils.getSession();
       OrdersEntity ordersEntity = session.find(OrdersEntity.class,id);
       return ordersEntity;
    }

    public void disconnect(){
        HibernateUtils.shutdown();
    }
}
