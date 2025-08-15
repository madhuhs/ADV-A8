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

        ContactEntity contactEntity = new ContactEntity();
        List<CallLogsEntity> callLogs = new ArrayList<>();

        contactEntity.setName("Contact1");
        contactEntity.setEmail("newEmail");
        contactEntity.setPhone("909090981");

        CallLogsEntity log1 = new CallLogsEntity();
        log1.setCallType(CALL_TYPE_MISSED);
        log1.setDateAndTime(LocalDateTime.now().toString());

        log1.setContactEntity(contactEntity);

        callLogs.add(log1);

        contactEntity.setCallLogs(callLogs);

        session.persist(contactEntity); // cascades to children because of CascadeType.ALL
        transaction.commit();



        System.out.println("Program ends...");
    }
}
