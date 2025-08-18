package com.jspiders.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shipping_address")
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String area;
    private String city;
    private int pinCode;

    @OneToOne(mappedBy = "shippingAddress",fetch = FetchType.LAZY)
    private OrdersEntity orders;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ShippingAddressEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
