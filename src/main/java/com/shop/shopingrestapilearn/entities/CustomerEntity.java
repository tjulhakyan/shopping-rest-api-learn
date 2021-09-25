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
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CustomerEntity {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean isActive;
    private Boolean isMailConfirmed;

    @CreatedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME(6)")
    private Instant updatedAt;
}
