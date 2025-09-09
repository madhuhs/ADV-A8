package com.jspiders;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DemoBean implements InitializingBean, DisposableBean {
    private String property;
    private int z1;
    public DemoBean(){
        System.out.println("1. Bean creation : Object of DemoBean created");
    }

    public void setProperty(String property) {
        this.property = property;
        System.out.println("2. Bean Initialization");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3. Custom intializations");
        this.z1 = 99;
    }

    public void executeTask(){
        System.out.println("4. Utilize the bean for Logics execution");
    }

    @Override
    public void destroy() {
        System.out.println("5. Bean destroyed");
    }
}
