package com.shop.shopingrestapilearn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CategoryEntity {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String imageUrl;

    @CreatedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant updatedAt;
}
