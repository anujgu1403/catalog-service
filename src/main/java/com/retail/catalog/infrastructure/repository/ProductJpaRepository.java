
package com.retail.catalog.infrastructure.repository;

import com.retail.catalog.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(Integer categoryId);
}
