
package com.retail.catalogservice.infrastructure.repositories.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
public class Product {

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

    @Column(nullable = false)
    private Integer category_id;

    @Column(nullable = false)
    private OffsetDateTime created_date;

    public Product() {}

    public Product(Integer product_id, String name, Double unit_price, String description, String image_url, Integer category_id, OffsetDateTime created_date) {
        this.product_id = product_id;
        this.name = name;
        this.unit_price = unit_price;
        this.description = description;
        this.image_url = image_url;
        this.category_id = category_id;
        this.created_date = created_date;
    }

    public Product(int i, String p1, double v) {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public OffsetDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(OffsetDateTime created_date) {
        this.created_date = created_date;
    }
}
