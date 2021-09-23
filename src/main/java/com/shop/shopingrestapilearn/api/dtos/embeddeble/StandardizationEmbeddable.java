package com.shop.shopingrestapilearn.api.dtos.embeddeble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardizationEmbeddable {
    private String standard;
    private String countryOfOrigin;
}
