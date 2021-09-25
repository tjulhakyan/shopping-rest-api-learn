package com.shop.shopingrestapilearn.mappers;

import org.mapstruct.*;
import com.shop.shopingrestapilearn.api.dtos.ProductDto;
import com.shop.shopingrestapilearn.entities.ProductEntity;


@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.ERROR, injectionStrategy=InjectionStrategy.CONSTRUCTOR)
public abstract class ProductMapper {

    @Mappings({
            @Mapping(target = "productId", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    public abstract ProductEntity productEntityMap(ProductDto dto);

    @Mappings({
            @Mapping(target = "productId", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    public abstract void productUpdateMap(@MappingTarget ProductEntity entity, ProductDto dto);

    public abstract ProductDto productDtoMap(ProductEntity entity);
}
