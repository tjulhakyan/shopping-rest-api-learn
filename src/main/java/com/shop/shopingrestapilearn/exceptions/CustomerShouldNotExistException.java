package com.shop.shopingrestapilearn.exceptions;

public class CustomerShouldNotExistException extends Exception{
    CustomerShouldNotExistException(String message){super(message);}

    public static CustomerShouldNotExistException withCustomerId(Long customerId){
        return new CustomerShouldNotExistException(String.format("customer with id %s should not exist", customerId));
    }
}
