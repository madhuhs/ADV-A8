package com.jspiders;

public class Address {
    private String city;
    private String state;
    private String area;
    private int pinCode;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", area='" + area + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
