package com.shop.shopingrestapilearn.entities;

import com.shop.shopingrestapilearn.entities.embeddeble.DimensionEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long productId;

    private Long categoryId;
    private String name;
    private Double price;
    private Boolean isActive;
    private Integer productQuantity;

    @ElementCollection
    private List<String> description;

    @ElementCollection
    private List<String> imageUrls;

    @Embedded
    private DimensionEmbeddable dimension;

    @CreatedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant updatedAt;
}
