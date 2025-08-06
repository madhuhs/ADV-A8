package com.jspiders.contacts.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ContactsRepositoryImpl implements ContactsRepository{
    private final String url = "";
    private final String username = "";
    private final String password = "";
    private Connection connection;
    public ContactsRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(url,username,password);
    }

    @Override
    public void save(ContactsEntity contactsEntity) {
        System.out.println("Contacts Saved to DB");
    }

    @Override
    public ContactsEntity getContactByName(String name) {
        return null;
    }

    @Override
    public ContactsEntity getContactByPhone(String phone) {
        return null;
    }

    @Override
    public List<ContactsEntity> getAll() {
        return null;
    }

    @Override
    public void update(ContactsEntity contactsEntity) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void deleteByPhone(String phone) {

    }
}
