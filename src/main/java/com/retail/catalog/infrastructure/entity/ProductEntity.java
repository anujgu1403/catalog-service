package com.retail.catalog.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;  // agar lombok use kar rahe ho
import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
@Data  // agar lombok hai, warna manual getters/setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double unit_price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image_url;

    // ← YEHI CHANGE: field camelCase kar do
    @Column(name = "category_id")  // DB column same rahega
    private Integer categoryId;     // ← underscore hata diya

    @Column(nullable = false)
    private OffsetDateTime created_date;

    // Agar lombok nahi hai toh manual getters/setters
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // baaki getters/setters...
}