package com.jspiders.contacts.tests;

import com.jspiders.contacts.repo.ContactsEntity;
import com.jspiders.contacts.repo.ContactsRepositoryImpl;

public class ContactsRepositoryTests {
    public static void runTests(){
        testSaveContact();
    }
    private static void testSaveContact(){
        try {
            ContactsRepositoryImpl contactsRepository = new ContactsRepositoryImpl();
            ContactsEntity contactsEntity = new ContactsEntity();
            contactsEntity.setName("");
            contactsRepository.save(contactsEntity);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
