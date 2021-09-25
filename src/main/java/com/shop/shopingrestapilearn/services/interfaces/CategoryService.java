package com.shop.shopingrestapilearn.services.interfaces;

import com.shop.shopingrestapilearn.api.dtos.CategoryDto;
import com.shop.shopingrestapilearn.exceptions.CategoryNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CategoryShouldNotExistException;

public interface CategoryService {
    CategoryDto getCategoryByCategoryId(Long categoryId) throws CategoryNotFoundException;
    CategoryDto createCategory(CategoryDto dto) throws CategoryShouldNotExistException;
    CategoryDto updateCategory(CategoryDto dto, Long categoryId) throws CategoryNotFoundException;
    void deleteCategory (Long categoryId) throws CategoryNotFoundException;
}
