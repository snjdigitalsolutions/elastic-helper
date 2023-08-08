package com.snjdigitalsolutions.elastic.action;

public class ClientNotOpenException extends RuntimeException {

    public ClientNotOpenException(String message)
    {
        super(message);
    }

}
