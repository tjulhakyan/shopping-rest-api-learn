package com.shop.shopingrestapilearn.exceptions;

public class ProductShouldNotExistException extends Exception{
    ProductShouldNotExistException (String message){super(message);}

    public static ProductShouldNotExistException withProductId(Long productId){
        return new ProductShouldNotExistException(String.format("product with id %s should not exist", productId));
    }
}
