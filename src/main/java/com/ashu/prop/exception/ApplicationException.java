package com.ashu.prop.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String errorMsg) {
        super(errorMsg);
    }

    public ApplicationException(String errorMsg, Exception ex) {
        super(errorMsg, ex);
    }
}
