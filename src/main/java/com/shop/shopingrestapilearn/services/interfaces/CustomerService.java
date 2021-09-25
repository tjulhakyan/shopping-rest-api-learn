package com.shop.shopingrestapilearn.services.interfaces;

import com.shop.shopingrestapilearn.api.dtos.CustomerDto;
import com.shop.shopingrestapilearn.exceptions.CustomerNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CustomerShouldNotExistException;

public interface CustomerService {
    CustomerDto getCustomerByCustomerId(Long customerId) throws CustomerNotFoundException;
    CustomerDto createCustomer(CustomerDto dto) throws CustomerShouldNotExistException;
    CustomerDto updateCustomer(CustomerDto dto, Long customerId) throws CustomerNotFoundException;
    void deleteCustomer (Long customerId) throws CustomerNotFoundException;
}
