package com.ashu.prop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(ApplicationException.class)
    public ProblemDetail onApplicationException(RuntimeException runtimeException) {
        logger.warn(runtimeException.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onRuntimeException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, runtimeException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleInputValidation(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrorList = ex.getFieldErrors();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Input data error!");
        for (FieldError fe: fieldErrorList) {
            problemDetail.setProperty(fe.getField(), fe.getDefaultMessage());
        }
        return problemDetail;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleBadJSONRequest(HttpMessageNotReadableException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid JSON format!");
    }

    @ExceptionHandler(DataAccessException.class)
    public ProblemDetail handleDataBaseExceptions(DataAccessException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
