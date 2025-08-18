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

        if(sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        session = sessionFactory.openSession();
        return session;
    }

    public static void shutdown(){
        session.close();
        sessionFactory.close();
    }
}
