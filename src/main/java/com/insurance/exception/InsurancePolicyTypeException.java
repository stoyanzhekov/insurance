package com.insurance.exception;

/**
 * Created by Stoyan on 2/19/2017.
 */
public class InsurancePolicyTypeException extends RuntimeException  {

    public InsurancePolicyTypeException(){
        super("Incorrect insurance policy type");
    }
}
