package com.shop.shopingrestapilearn.services.interfaces;

import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.exceptions.ProductNotFoundException;
import com.shop.shopingrestapilearn.exceptions.ProductShouldNotExistException;

public interface ProductService {
    ProductDto getProductByProductId(Long productId) throws ProductNotFoundException;
    ProductDto createProduct(ProductDto dto) throws ProductShouldNotExistException;
    ProductDto updateProduct(ProductDto dto, Long productId) throws ProductNotFoundException;
    void deleteProduct (Long productId) throws ProductNotFoundException;
}
