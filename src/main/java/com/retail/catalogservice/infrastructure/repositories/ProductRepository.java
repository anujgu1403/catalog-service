
package com.retail.catalogservice.infrastructure.repositories;

import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
