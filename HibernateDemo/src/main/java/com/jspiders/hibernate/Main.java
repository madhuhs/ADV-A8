package com.jspiders.hibernate;

import com.jspiders.hibernate.entities.ContactEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static final String hibernateCfgFile = "hibernate.cfg.xml";

    public static void main(String[] args) {
        System.out.println("Starts...");

        //Load configuration
        Configuration configuration = new Configuration();
        configuration.configure(hibernateCfgFile);

        //Create session (Connection)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

       ContactEntity contactEntity = new
              ContactEntity(0,"A","999999999","test@gmail.com");

       //save
       session.persist(contactEntity);

        //Read
        ContactEntity contactEntity1 = session.find(ContactEntity.class,1);
        System.out.println(contactEntity1.getId());
        System.out.println(contactEntity1.getName());
        System.out.println(contactEntity1.getEmail());
        System.out.println(contactEntity1.getPhone());


        //update
        ContactEntity contactEntity2 = session.find(ContactEntity.class,2);
        contactEntity2.setEmail("newEmail2@gmail.com");

        //delete
        ContactEntity contactEntity3 = session.find(ContactEntity.class,3);
        session.remove(contactEntity3);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("ends...");
    }
}