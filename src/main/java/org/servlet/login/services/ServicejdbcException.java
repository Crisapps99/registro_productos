package org.servlet.login.services;

public class ServicejdbcException  extends RuntimeException{
    public ServicejdbcException(String message) {
        super(message);
    }
    public ServicejdbcException(String message, Throwable cause){
        super(message, cause);
    }

}
