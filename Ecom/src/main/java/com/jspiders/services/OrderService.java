package com.jspiders.services;

import com.jspiders.data.entities.OrdersEntity;
import com.jspiders.data.entities.ShippingAddressEntity;
import com.jspiders.data.repo.OrdersRepository;

public class OrderService {

    private final OrdersRepository ordersRepository = new OrdersRepository();
    public void createOrder(){
        ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();
        shippingAddressEntity.setArea("hebbal");
        shippingAddressEntity.setCity("bangalore");
        shippingAddressEntity.setPinCode(50001);
        shippingAddressEntity.setType("Office");

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setPrice(1000);
        ordersEntity.setQty(2);

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






