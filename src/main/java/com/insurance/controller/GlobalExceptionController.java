package com.insurance.controller;

import com.insurance.exception.InsurancePolicyTypeException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Stoyan on 2/19/2017.
 */

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(InsurancePolicyTypeException.class)
    public ResponseEntity<Object> handleAllException(InsurancePolicyTypeException ex, WebRequest request) {

    	return handleExceptionInternal(ex, ex.getMessage(), 
    	          new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

}
