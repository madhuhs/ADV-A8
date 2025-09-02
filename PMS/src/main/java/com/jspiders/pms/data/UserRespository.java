package com.jspiders.pms.data;

import org.springframework.stereotype.Repository;

@Repository
public class UserRespository {
    public void save(){
        System.out.println("data saved to user-db");
    }
}
