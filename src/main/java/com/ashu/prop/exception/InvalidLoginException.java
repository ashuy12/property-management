package com.ashu.prop.exception;

public class InvalidLoginException extends ApplicationException {

    public InvalidLoginException(String errorMessage) {
        super(errorMessage);
    }
}
