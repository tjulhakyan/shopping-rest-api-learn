package com.shop.shopingrestapilearn.api.dtos;

import com.shop.shopingrestapilearn.api.dtos.embeddeble.Dimension;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private Long categoryId;
    private String name;
    private Double price;
    private Boolean isActive;
    private Integer productQuantity;

    private List<String> description;
    private List<String> imageUrls;

    private Dimension dimension;
}


