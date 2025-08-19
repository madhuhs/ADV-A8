package com.jspiders.services;

import com.jspiders.data.entities.OrderItemsEntity;
import com.jspiders.data.entities.OrdersEntity;
import com.jspiders.data.entities.ShippingAddressEntity;
import com.jspiders.data.repo.OrdersRepository;

import java.util.List;

public class OrderService {

    private final OrdersRepository ordersRepository = new OrdersRepository();
    public void createOrder(){
        ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();
        shippingAddressEntity.setArea("hebbal");
        shippingAddressEntity.setCity("bangalore");
        shippingAddressEntity.setPinCode(50001);
        shippingAddressEntity.setType("Office");

        OrderItemsEntity orderItem1 = new OrderItemsEntity();// <--- create orderItem1
        orderItem1.setName("Item1");
        orderItem1.setPrice(200);
        orderItem1.setQty(1);

        OrderItemsEntity orderItem2 = new OrderItemsEntity();// <--- create orderItem2
        orderItem2.setName("Item2");
        orderItem2.setPrice(130);
        orderItem2.setQty(3);

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.addOrderItem(orderItem1);// <--- set orderItem1 to OrdersEntity
        ordersEntity.addOrderItem(orderItem2);// <--- set orderItem2 to OrdersEntity

        List<OrderItemsEntity> orderItems = ordersEntity.getOrderItems();
        double totalPrice = 0;
        for (int i=0;i<orderItems.size();i++){
           totalPrice = totalPrice + orderItems.get(i).getPrice();
        }

        ordersEntity.setPrice(totalPrice);
        int totalQty = ordersEntity.getOrderItems().size();
        ordersEntity.setQty(totalQty);

        ordersEntity.setShippingAddress(shippingAddressEntity);
        shippingAddressEntity.setOrders(ordersEntity);

        ordersRepository.createOrder(ordersEntity);
    }

    public void findOrderById(long id){
      OrdersEntity ordersEntity =  ordersRepository.findOrderById(id);
        System.out.println(ordersEntity);
    }

    public void disconnect(){
        ordersRepository.disconnect();
    }

}






