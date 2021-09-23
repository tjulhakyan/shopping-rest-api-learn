package com.shop.shopingrestapilearn.api.dtos;

import com.shop.shopingrestapilearn.api.dtos.embeddeble.DimensionEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private Long categoryId;
    private String name;
    private Double price;
    private String description;
    private Boolean isActive;

    @ElementCollection
    private List<String> images;

    @Embedded
    private DimensionEmbeddable dimension;
}


