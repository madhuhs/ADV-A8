package com.jspiders.hibernate.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main3 {
    private static final String hibernateCfgFile = "hibernate.cfg.xml";
    public static void main(String[] args) {
        System.out.println("Program starts...");

        Configuration config = new Configuration();
        config.configure(hibernateCfgFile);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
    }
}
