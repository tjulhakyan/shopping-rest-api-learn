package com.shop.shopingrestapilearn.api.dtos.embeddeble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standardization {
    private String standard;
    private String countryOfOrigin;
}
