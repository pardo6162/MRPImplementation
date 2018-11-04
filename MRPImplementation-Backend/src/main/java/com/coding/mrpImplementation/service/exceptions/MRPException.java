package com.coding.mrpImplementation.service.exceptions;

public class MRPException extends Exception {
    public MRPException(){

    }


    public MRPException(String message){

        super(message);
    }

    public MRPException(Throwable cause) {
        super(cause);
    }

}
