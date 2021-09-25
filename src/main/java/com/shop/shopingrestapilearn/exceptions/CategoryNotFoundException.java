package com.shop.shopingrestapilearn.exceptions;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException (String message) {super(message);}

    public static CategoryNotFoundException withCategoryId(Long categoryId){
        return new CategoryNotFoundException(String.format("There is no category found with id \"%s\"", categoryId));
    }
}
