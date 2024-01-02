package com.rafael.springbootmondodb.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String mensage){
        super(mensage);
    }
}
