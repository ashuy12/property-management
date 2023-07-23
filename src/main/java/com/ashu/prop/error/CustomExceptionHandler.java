package com.ashu.prop.error;

import com.ashu.prop.service.exception.PropertyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(PropertyNotFoundException.class)
    public ProblemDetail onRuntimeException(RuntimeException runtimeException) {
        ProblemDetail problemDetail =
            ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
        problemDetail.setProperty("API Error Message", runtimeException.getMessage());
        logger.error("ERROR MESSAGE : " + runtimeException);
        return problemDetail;
    }
}
