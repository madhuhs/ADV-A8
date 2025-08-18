package com.jspiders.data.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final String hibernateCfgFile = "hibernate.cfg.xml";
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    public static Session getSession(){
        //Load configuration
        Configuration configuration = new Configuration();
        configuration.configure(hibernateCfgFile);

        //Build Session Factory
        if(sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("SessionFactory created");
        }
        //Open and return the Session object (connection)
        session = sessionFactory.openSession();
        System.out.println("Session created");
        return session;
    }

    public static void shutdown(){
        session.close();
        sessionFactory.close();
        session = null;
        sessionFactory = null;

        System.out.println("Session closed");
        System.out.println("SessionFactory closed");
    }
}
