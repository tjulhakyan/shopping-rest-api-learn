package com.shop.shopingrestapilearn.api.controllers;

import com.shop.shopingrestapilearn.api.dtos.CustomerDto;
import com.shop.shopingrestapilearn.exceptions.CustomerNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CustomerShouldNotExistException;
import com.shop.shopingrestapilearn.services.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/")
    public CustomerDto createCustomer(@RequestBody CustomerDto dto) throws CustomerShouldNotExistException {
        log.info(dto.toString());
        return customerService.createCustomer(dto);
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomerBycustomerId(@PathVariable Long customerId) throws CustomerNotFoundException {
        log.info(customerId.toString());
        return customerService.getCustomerByCustomerId(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDto updateCustomer(@PathVariable Long customerId,
                                    @RequestBody CustomerDto dto) throws CustomerNotFoundException {
        log.info(dto.toString());
        return customerService.updateCustomer(dto, customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        log.info(customerId.toString());
        customerService.deleteCustomer(customerId);
    }
}
