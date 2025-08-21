package com.jspiders;

import com.jspiders.services.ProductService;

public class Main2 {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
       // productService.findProductByName("iphone");
       // productService.findProductByAbovePrice(100000);
        productService.productByName("samsung");
    }
}
