package com.shop.shopingrestapilearn.api.controllers;

import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.exceptions.ProductNotFoundException;
import com.shop.shopingrestapilearn.exceptions.ProductShouldNotExistException;
import com.shop.shopingrestapilearn.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody ProductDto dto) throws ProductShouldNotExistException {
        log.info(dto.toString());
        return productService.createProduct(dto);
    }

    @GetMapping("/{productId}")
    public ProductDto getProductByproductId(@PathVariable Long productId) throws ProductNotFoundException {
        log.info(productId.toString());
        return productService.getProductByProductId(productId);
    }

    @PutMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId,
            @RequestBody ProductDto dto) throws ProductNotFoundException {
        log.info(dto.toString());
        return productService.updateProduct(dto, productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        log.info(productId.toString());
        productService.deleteProduct(productId);
    }

}
