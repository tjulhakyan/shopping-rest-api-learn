package com.shop.shopingrestapilearn.services.interfaces;

import com.shop.shopingrestapilearn.api.dtos.ProductDto;

public interface ProductService {
    ProductDto getProductByProductId(Long productId);
    ProductDto createProduct(ProductDto dto);
    ProductDto updateProduct(ProductDto dto, Long productId);
    void deleteProduct (Long productId);
}
