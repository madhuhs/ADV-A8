package com.jspiders;

public class Demo {
    int v1;
    double z1;
    public Demo(int v1){
        this.v1 = v1;
    }
    public Demo(){
        System.out.println("Object of Demo class is Created");
    }
    public void test(){
        System.out.println("this is test() of Demo class");
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }
}
