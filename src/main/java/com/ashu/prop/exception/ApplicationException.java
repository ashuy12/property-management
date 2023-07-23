package com.ashu.prop.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String errorMsg) {
        super(errorMsg);
    }
}
