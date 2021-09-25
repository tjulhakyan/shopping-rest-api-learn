package com.shop.shopingrestapilearn.exceptions;

public class CategoryShouldNotExistException extends Exception{
    CategoryShouldNotExistException (String message){super(message);}

    public static CategoryShouldNotExistException withCategoryId(Long productId){
        return new CategoryShouldNotExistException(String.format("Category with id %s should not exist", productId));
    }
}
