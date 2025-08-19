package com.jspiders.data.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    private int qty;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id",referencedColumnName = "id")
    private ShippingAddressEntity shippingAddress;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItemsEntity> orderItems = new ArrayList<>();

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public ShippingAddressEntity getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressEntity shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void addOrderItem(OrderItemsEntity orderItemsEntity){
      orderItems.add(orderItemsEntity);
      orderItemsEntity.setOrders(this);//link orderItem to OrderEntity
    }

    public List<OrderItemsEntity> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", price=" + price +
                ", qty=" + qty +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
