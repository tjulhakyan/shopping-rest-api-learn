package com.shop.shopingrestapilearn.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean isActive;
    private Boolean isMailConfirmed;
}
