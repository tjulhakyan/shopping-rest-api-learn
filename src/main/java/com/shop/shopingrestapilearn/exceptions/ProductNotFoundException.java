package com.shop.shopingrestapilearn.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException (String message) {super(message);}

    public static ProductNotFoundException withProductId(Long productId){
        return new ProductNotFoundException(String.format("There is no product found with id \"%s\"", productId));
    }
}
