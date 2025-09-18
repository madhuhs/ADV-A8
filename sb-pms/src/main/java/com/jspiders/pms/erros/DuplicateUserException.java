package com.jspiders.pms.erros;

public class DuplicateUserException 
        extends RuntimeException{

    public DuplicateUserException(String errorMessage){
        super(errorMessage);
    }
}
