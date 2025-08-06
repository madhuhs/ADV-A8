package com.jspiders.contacts.repo;

import java.util.List;

public interface ContactsRepository {
    void save(ContactsEntity contactsEntity);

    ContactsEntity getContactByName(String name);

    ContactsEntity getContactByPhone(String phone);

    List<ContactsEntity> getAll();

    void update(ContactsEntity contactsEntity);

    void deleteByName(String name);

    void deleteByPhone(String phone);
}
