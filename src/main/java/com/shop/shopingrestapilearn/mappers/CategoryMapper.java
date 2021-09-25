package com.shop.shopingrestapilearn.mappers;

import com.shop.shopingrestapilearn.api.dtos.CategoryDto;
import com.shop.shopingrestapilearn.entities.CategoryEntity;
import org.mapstruct.*;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.ERROR, injectionStrategy= InjectionStrategy.CONSTRUCTOR)
public abstract class CategoryMapper {

    public abstract CategoryDto categoryDtoMap(CategoryEntity entity);

    public abstract CategoryEntity categoryEntityMap(CategoryDto dto);

    @Mapping(target = "categoryId", ignore = true)
    public abstract void categoryUpdateMap(@MappingTarget CategoryEntity entity, CategoryDto dto);
}
