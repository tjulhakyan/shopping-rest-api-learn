package com.shop.shopingrestapilearn.services;

import com.shop.shopingrestapilearn.api.dtos.CategoryDto;
import com.shop.shopingrestapilearn.entities.CategoryEntity;
import com.shop.shopingrestapilearn.exceptions.CategoryNotFoundException;
import com.shop.shopingrestapilearn.exceptions.CategoryShouldNotExistException;
import com.shop.shopingrestapilearn.mappers.CategoryMapper;
import com.shop.shopingrestapilearn.repositories.CategoryRepository;
import com.shop.shopingrestapilearn.services.interfaces.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CategoryDto dto) throws CategoryShouldNotExistException {
        checkingCategoryByCategoryIdOrElseThrow(dto.getCategoryId());
        CategoryEntity categoryEntity=categoryMapper.categoryEntityMap(dto);
        CategoryEntity createdCategoryEntity=categoryRepository.save(categoryEntity);
        return categoryMapper.categoryDtoMap(createdCategoryEntity);
    }

    @Override
    public CategoryDto getCategoryByCategoryId(Long categoryId) throws CategoryNotFoundException {
        CategoryEntity categoryEntity=getCategoryByCategoryIdOrElseThrow(categoryId);
        return categoryMapper.categoryDtoMap(categoryEntity);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto dto, Long categoryId) throws CategoryNotFoundException {
        CategoryEntity categoryEntity=getCategoryByCategoryIdOrElseThrow(categoryId);
        categoryMapper.categoryUpdateMap(categoryEntity, dto);
        CategoryEntity CreatedCategoryEntity=categoryRepository.save(categoryEntity);
        return categoryMapper.categoryDtoMap(CreatedCategoryEntity);
    }

    @Override
    public void deleteCategory(Long categoryId) throws CategoryNotFoundException {
        CategoryEntity categoryEntity=getCategoryByCategoryIdOrElseThrow(categoryId);
        categoryRepository.delete(categoryEntity);
    }

    private CategoryEntity getCategoryByCategoryIdOrElseThrow(Long categoryId) throws CategoryNotFoundException {
        return categoryRepository.findByCategoryId(categoryId).orElseThrow(()-> CategoryNotFoundException.withCategoryId(categoryId));
    }

    private void checkingCategoryByCategoryIdOrElseThrow(Long categoryId) throws CategoryShouldNotExistException {
        Optional.ofNullable(categoryRepository.findByCategoryId(categoryId)).orElseThrow(()-> CategoryShouldNotExistException.withCategoryId(categoryId));
    }
}
