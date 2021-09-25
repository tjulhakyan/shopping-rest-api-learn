package com.shop.shopingrestapilearn.api.controllers;

import com.shop.shopingrestapilearn.api.dtos.CategoryDto;
import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.exceptions.CategoryNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CategoryShouldNotExistException;
import com.shop.shopingrestapilearn.exceptions.ProductNotFoundException;
import com.shop.shopingrestapilearn.exceptions.ProductShouldNotExistException;
import com.shop.shopingrestapilearn.services.interfaces.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public CategoryDto createProduct(@RequestBody CategoryDto dto) throws CategoryShouldNotExistException {
        log.info(dto.toString());
        return categoryService.createCategory(dto);
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategoryBycategoryId(@PathVariable Long categoryId) throws CategoryNotFoundException {
        log.info(categoryId.toString());
        return categoryService.getCategoryByCategoryId(categoryId);
    }

    @PutMapping("/{categoryId}")
    public CategoryDto updateCategory(@PathVariable Long categoryId,
                                    @RequestBody CategoryDto dto) throws CategoryNotFoundException {
        log.info(dto.toString());
        return categoryService.updateCategory(dto, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) throws CategoryNotFoundException {
        log.info(categoryId.toString());
        categoryService.deleteCategory(categoryId);
    }
}
