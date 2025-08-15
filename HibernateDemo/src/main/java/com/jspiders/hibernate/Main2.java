package com.jspiders.hibernate;

import com.jspiders.hibernate.entities.CallLogsEntity;
import com.jspiders.hibernate.entities.ContactEntity;
import com.jspiders.hibernate.entities.ProfilePictureEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static final String hibernateCfgFile = "hibernate.cfg.xml";

    private static final String CALL_TYPE_INCOMING = "Incoming";
    private static final String CALL_TYPE_OUTGOING = "Outgoing";
    private static final String CALL_TYPE_MISSED = "Missed";

    public static void main(String[] args) {
        System.out.println("Program starts...");

        Configuration config = new Configuration();
        config.configure(hibernateCfgFile);

       SessionFactory sessionFactory = config.buildSessionFactory();
       Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //Insert
////        ContactEntity contactEntity = new ContactEntity();
////        contactEntity.setName("NewContact1");
////        contactEntity.setPhone("9000000001");
////        contactEntity.setEmail("newEmail@test.com");
//
//        List<CallLogsEntity> callLogs = new ArrayList<>();

        ContactEntity contactEntity = session.find(ContactEntity.class,1);
        List<CallLogsEntity> callLogs = contactEntity.getCallLogs();

        CallLogsEntity callLog1 = new CallLogsEntity();
        callLog1.setCallType(CALL_TYPE_MISSED);
        callLog1.setDateAndTime(LocalDateTime.now().toString());
        callLog1.setContactEntity(contactEntity);
        callLogs.add(callLog1);
        contactEntity.setCallLogs(callLogs);

        session.persist(contactEntity);
        transaction.commit();



        System.out.println("Program ends...");
    }
}
