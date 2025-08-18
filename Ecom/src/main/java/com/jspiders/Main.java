package com.jspiders;

import com.jspiders.services.OrderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");
        OrderService orderService = new OrderService();
        //orderService.createOrder();
        orderService.findOrderById(1);
        orderService.disconnect();
        System.out.println("Program ends...");
    }
}