package com.jspiders.contacts.repo;

import java.sql.*;
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
    public void saveAndUpdate(String phone) throws SQLException {
        connection.setAutoCommit(false);
        Savepoint sp = null;
        try {
            //Save
            PreparedStatement ps1 = connection.prepareStatement("INSERT");
            ps1.setString(1, "");
            ps1.execute();

            sp =  connection.setSavepoint("SP1");

            //Update
            PreparedStatement ps2 = connection.prepareStatement("UPDATE");
            ps2.setString(1, "");
            ps2.executeUpdate();
            connection.commit();//Commit or Save the transaction
        }
        catch (Exception e){
            connection.rollback(sp);
            connection.commit();
        }
        finally {
            connection.setAutoCommit(true);
        }
    }

    public void addBulkData() throws SQLException {
        PreparedStatement ps1 = null;
        for (int i = 1; i<=1000; i++) {
            ps1 = connection.prepareStatement("INSERT");
            ps1.addBatch();
        }
        ps1.executeBatch();
    }













}
