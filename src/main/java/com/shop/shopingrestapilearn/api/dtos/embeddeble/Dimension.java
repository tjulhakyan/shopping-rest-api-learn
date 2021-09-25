package com.shop.shopingrestapilearn.api.dtos.embeddeble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {
    private Double size;
    private Double length;
    private Double height;
    private Double width;

    private Standardization standardization;

}
