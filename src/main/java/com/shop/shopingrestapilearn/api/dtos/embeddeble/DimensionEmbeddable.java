package com.shop.shopingrestapilearn.api.dtos.embeddeble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DimensionEmbeddable {
    private Double size;
    private Double length;
    private Double height;
    private Double width;

    @Embedded
    private StandardizationEmbeddable standardization;

}
