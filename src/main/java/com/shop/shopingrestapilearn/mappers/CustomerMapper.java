package com.shop.shopingrestapilearn.mappers;

import com.shop.shopingrestapilearn.api.dtos.CustomerDto;
import com.shop.shopingrestapilearn.entities.CustomerEntity;
import org.mapstruct.*;


@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.ERROR, injectionStrategy=InjectionStrategy.CONSTRUCTOR)
public abstract class CustomerMapper {

    @Mappings({
            @Mapping(target = "customerId", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    public abstract CustomerEntity customerEntityMap(CustomerDto dto);

    @Mappings({
            @Mapping(target = "customerId", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    public abstract void customerUpdateMap(@MappingTarget CustomerEntity entity, CustomerDto dto);

    public abstract CustomerDto customerDtoMap(CustomerEntity entity);
}
