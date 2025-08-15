package com.jspiders.hibernate;

import com.jspiders.hibernate.entities.CallLogsEntity;
import com.jspiders.hibernate.entities.ContactEntity;
import com.jspiders.hibernate.entities.GroupEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class Main3 {
    private static final String hibernateCfgFile = "hibernate.cfg.xml";
    public static void main(String[] args) {
        System.out.println("Program starts...");

        Configuration config = new Configuration();
        config.configure(hibernateCfgFile);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

//        ContactEntity contactEntityFromDb = session.find(ContactEntity.class,1);
//
//        GroupEntity groupEntity = new GroupEntity();
//        groupEntity.setName("Group1");
//
//        List<GroupEntity> groupEntityList = contactEntityFromDb.getGroups();
//        groupEntityList.add(groupEntity);
//
//        session.persist(contactEntityFromDb);

        ContactEntity contactEntityFromDb = session.find(ContactEntity.class,1);
        System.out.println(contactEntityFromDb.getName());
        System.out.println(contactEntityFromDb.getGroups());
        transaction.commit();

        System.out.println("Program ends...");
    }
}
