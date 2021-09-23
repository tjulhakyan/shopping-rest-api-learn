package com.shop.shopingrestapilearn.services;

import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@Data
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    @Override
    public ProductDto getProductByProductId(Long productId) {
        return null;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto dto, Long productId) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
