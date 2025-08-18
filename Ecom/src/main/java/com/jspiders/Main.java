package com.jspiders;

import com.jspiders.data.util.HibernateUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        HibernateUtils.getSession();
        HibernateUtils.shutdown();
        System.out.println("Program ends...");
    }
}