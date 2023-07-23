package com.ashu.prop.exception;

public class PropertyNotFoundException extends ApplicationException {

    public PropertyNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public PropertyNotFoundException(String errorMessage, Exception ex) {
        super(errorMessage, ex);
    }
}
