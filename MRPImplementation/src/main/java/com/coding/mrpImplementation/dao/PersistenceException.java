package com.coding.mrpImplementation.dao;

public class PersistenceException extends Exception {

    public PersistenceException(String message){
        super(message);
    }

    public PersistenceException(String message, Throwable cause){
        super(message,cause);
    }


}
