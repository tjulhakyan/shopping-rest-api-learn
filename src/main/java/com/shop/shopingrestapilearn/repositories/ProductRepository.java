package com.shop.shopingrestapilearn.repositories;

import com.shop.shopingrestapilearn.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByProductId(Long productId);

    @Query(value =  "select p from ProductEntity p where p.dimension.standardization.standard IN :standard" )
    List<ProductEntity> findAllByStandard(@Param("standard") Collection<String> standard);
}
