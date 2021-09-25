package com.shop.shopingrestapilearn.services;

import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.entities.ProductEntity;
import com.shop.shopingrestapilearn.exceptions.ProductNotFoundException;
import com.shop.shopingrestapilearn.exceptions.ProductShouldNotExistException;
import com.shop.shopingrestapilearn.mappers.ProductMapper;
import com.shop.shopingrestapilearn.repositories.ProductRepository;
import com.shop.shopingrestapilearn.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Data
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto dto) throws ProductShouldNotExistException {
        checkingProductByProductIdOrElseThrow(dto.getProductId());
        ProductEntity productEntity=productMapper.productEntityMap(dto);
        ProductEntity createdProductEntity=productRepository.save(productEntity);
//        List<String> standards=new ArrayList<>(){{
//            add("EU");
//            add("AM");
//            add("CA");
//        }};
//        List<ProductEntity> ProductEntities = productRepository.findAllByStandard(standards);
//        System.out.println("====================");
//        ProductEntities.forEach(System.out::println);
//        System.out.println("====================");
        return productMapper.productDtoMap(createdProductEntity);
    }

    @Override
    public ProductDto getProductByProductId(Long productId) throws ProductNotFoundException {
        ProductEntity productEntity=getProductByProductIdOrElseThrow(productId);
        return productMapper.productDtoMap(productEntity);
    }

    @Override
    public ProductDto updateProduct(ProductDto dto, Long productId) throws ProductNotFoundException {
        ProductEntity productEntity=getProductByProductIdOrElseThrow(productId);
        productMapper.productUpdateMap(productEntity, dto);
        ProductEntity CreatedProductEntity=productRepository.save(productEntity);
        return productMapper.productDtoMap(CreatedProductEntity);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        ProductEntity productEntity=getProductByProductIdOrElseThrow(productId);
        productRepository.delete(productEntity);
    }

    private ProductEntity getProductByProductIdOrElseThrow(Long productId) throws ProductNotFoundException {
        return productRepository.findByProductId(productId).orElseThrow(()-> ProductNotFoundException.withProductId(productId));
    }

    private void checkingProductByProductIdOrElseThrow(Long productId) throws ProductShouldNotExistException {
        Optional.ofNullable(productRepository.findByProductId(productId)).orElseThrow(()-> ProductShouldNotExistException.withProductId(productId));
    }
}
