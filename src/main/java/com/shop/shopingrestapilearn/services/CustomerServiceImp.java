package com.shop.shopingrestapilearn.services;

import com.shop.shopingrestapilearn.api.dtos.CustomerDto;
import com.shop.shopingrestapilearn.entities.CustomerEntity;
import com.shop.shopingrestapilearn.exceptions.CustomerNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CustomerShouldNotExistException;
import com.shop.shopingrestapilearn.mappers.CustomerMapper;
import com.shop.shopingrestapilearn.repositories.CustomerRepository;
import com.shop.shopingrestapilearn.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Data
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto dto) throws CustomerShouldNotExistException {
        checkingCustomerByCustomerIdOrElseThrow(dto.getCustomerId());
        CustomerEntity customerEntity=customerMapper.customerEntityMap(dto);
        CustomerEntity createdCustomerEntity=customerRepository.save(customerEntity);

        return customerMapper.customerDtoMap(createdCustomerEntity);
    }

    @Override
    public CustomerDto getCustomerByCustomerId(Long customerId) throws CustomerNotFoundException {
        CustomerEntity customerEntity=getCustomerByCustomerIdOrElseThrow(customerId);
        return customerMapper.customerDtoMap(customerEntity);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto dto, Long customerId) throws CustomerNotFoundException {
        CustomerEntity customerEntity=getCustomerByCustomerIdOrElseThrow(customerId);
        customerMapper.customerUpdateMap(customerEntity, dto);
        CustomerEntity CreatedCustomerEntity=customerRepository.save(customerEntity);
        return customerMapper.customerDtoMap(CreatedCustomerEntity);
    }

    @Override
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException {
        CustomerEntity customerEntity=getCustomerByCustomerIdOrElseThrow(customerId);
        customerRepository.delete(customerEntity);
    }

    private CustomerEntity getCustomerByCustomerIdOrElseThrow(Long customerId) throws CustomerNotFoundException {
        return customerRepository.findByCustomerId(customerId).orElseThrow(()-> CustomerNotFoundException.withCustomerId(customerId));
    }

    private void checkingCustomerByCustomerIdOrElseThrow(Long customerId) throws CustomerShouldNotExistException {
        Optional.ofNullable(customerRepository.findByCustomerId(customerId)).orElseThrow(()-> CustomerShouldNotExistException.withCustomerId(customerId));
    }
}
