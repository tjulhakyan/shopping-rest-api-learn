package com.shop.shopingrestapilearn.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message) {super(message);}

    public static CustomerNotFoundException withCustomerId(Long customerId){
        return new CustomerNotFoundException(String.format("There is no customer found with id \"%s\"", customerId));
    }
}
