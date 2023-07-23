package com.ashu.prop.service.exception;

public class PropertyNotFoundException extends RuntimeException {

    String errorMessage;
    public PropertyNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
